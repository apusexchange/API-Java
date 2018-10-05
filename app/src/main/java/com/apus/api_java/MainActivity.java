package com.apus.api_java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.apus.sdkjava.controller.ApusPaymentAPI;
import com.apus.sdkjava.domain.request.CancelPayment;
import com.apus.sdkjava.domain.request.MakePayment;
import com.apus.sdkjava.domain.request.RechargeCryptoBalance;
import com.apus.sdkjava.domain.request.RecurringPayment;
import com.apus.sdkjava.domain.request.SearchPayment;
import com.apus.sdkjava.domain.response.ApusResponse;
import com.apus.sdkjava.domain.response.BlockChain;
import com.apus.sdkjava.domain.response.Currency;
import com.apus.sdkjava.domain.response.Period;
import com.apus.sdkjava.rest.RestService;

public class MainActivity extends AppCompatActivity implements RestService.ApusCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApusPaymentAPI apusPaymentAPI = new ApusPaymentAPI(ApusPaymentAPI.Environment.SANDBOX);
        apusPaymentAPI.setCallback(new RestService.ApusCallback() {
            @Override
            public void onResponse(ApusResponse apusResponse) {

            }
        });


        //makePayment(apusPaymentAPI);
        //rechargeCryptoBalance(apusPaymentAPI);
       // recurringPayment(apusPaymentAPI);
        //searchPayment(apusPaymentAPI);
        cancelPayment(apusPaymentAPI);
    }

    private void cancelPayment(ApusPaymentAPI apusPaymentAPI) {
        apusPaymentAPI.start(new CancelPayment.Builder()
                        .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                        .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                        .withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
                        .build());
    }

    private void searchPayment(ApusPaymentAPI apusPaymentAPI) {
        apusPaymentAPI.start(new SearchPayment.Builder()
                        .withBlockchain(BlockChain.Type.LTC)
                        .withCurrency(Currency.Type.BRL)
                        .withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
                        .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                        .build());
    }

    private void rechargeCryptoBalance(ApusPaymentAPI apusPaymentAPI) {
        apusPaymentAPI.start(new RechargeCryptoBalance.Builder()
                        .withAmount(10)
                        .withBlockChain(BlockChain.Type.LTC)
                        .withCurrency(Currency.Type.BRL)
                        .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                        .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                        .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                        .build());
    }

    private void recurringPayment(ApusPaymentAPI apusPaymentAPI) {
        apusPaymentAPI.start(new RecurringPayment.Builder()
                        .withAmount(10)
                        .withBlockChain(BlockChain.Type.LTC)
                        .withCurrency(Currency.Type.BRL)
                        .withPeriod(Period.M)
                        .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                        .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                        .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                        .build());
    }

    private void makePayment(ApusPaymentAPI apusPaymentAPI) {
        apusPaymentAPI.start(new MakePayment.Builder()
                        .withAmount(10)
                        .withBlockChain(BlockChain.Type.LTC)
                        .withCurrency(Currency.Type.BRL)
                        .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                        .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                        .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                        .build());
    }

    @Override
    public void onResponse(ApusResponse apusResponse) {
        Log.e("TAG", apusResponse.getStatus().toString());
    }
}
