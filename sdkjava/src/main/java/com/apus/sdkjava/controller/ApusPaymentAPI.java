package com.apus.sdkjava.controller;

import com.apus.sdkjava.domain.request.CancelPayment;
import com.apus.sdkjava.domain.request.MakePayment;
import com.apus.sdkjava.domain.request.RechargeCryptoBalance;
import com.apus.sdkjava.domain.request.RecurringPayment;
import com.apus.sdkjava.domain.request.SearchPayment;
import com.apus.sdkjava.domain.response.CancelResponse;
import com.apus.sdkjava.domain.response.PaymentResponse;
import com.apus.sdkjava.domain.response.RechargeResponse;
import com.apus.sdkjava.domain.response.RecurringPaymentResponse;
import com.apus.sdkjava.domain.response.SearchResponse;
import com.apus.sdkjava.rest.RestService;

public class ApusPaymentAPI {

    public ApusPaymentAPI(Environment environment) {
        this.url = (environment == Environment.SANDBOX)?"https://sandbox.apuspayments.com/v1/":"https://api.apuspayments.com/v1/";
    }

    private RestService.ApusCallback callback;
    private String url;

    public void setCallback(RestService.ApusCallback callback) {
        this.callback = callback;
    }

    public void start(MakePayment makePayment) {
        RestService<MakePayment,PaymentResponse> restService =  new RestService<MakePayment,PaymentResponse>(url+"checkout/");
        restService.post(makePayment, PaymentResponse.class, callback);
    }

    public void start(CancelPayment cancelPayment) {
        RestService<CancelPayment,CancelResponse> restService =  new RestService<CancelPayment,CancelResponse>(url+"checkout/");
        restService.delete(cancelPayment, CancelResponse.class, callback);
    }

    public void start(RechargeCryptoBalance rechargeCryptoBalance) {
        RestService<RechargeCryptoBalance,RechargeResponse> restService =
                new RestService<RechargeCryptoBalance,RechargeResponse>(url+"checkin/");

        restService.post(rechargeCryptoBalance, RechargeResponse.class, callback);
    }

    public void start(RecurringPayment recurringPayment) {

        RestService<RecurringPayment,RecurringPaymentResponse> restService =
                new RestService<RecurringPayment,RecurringPaymentResponse>(url+"checkout/recurrent");

        restService.post(recurringPayment, RecurringPaymentResponse.class, callback);
    }

    public void start(SearchPayment searchPayment) {
        RestService<SearchPayment,SearchResponse> restService =
                new RestService<SearchPayment,SearchResponse>(url+"checkout/"+searchPayment.getVendorKey());

        restService.get(searchPayment.toParam(), SearchResponse.class, callback);
    }

    public enum Environment{
        SANDBOX, PRODUCTION
    }

}
