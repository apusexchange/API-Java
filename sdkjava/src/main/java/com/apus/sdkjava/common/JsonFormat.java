package com.apus.sdkjava.common;

import com.apus.sdkjava.domain.response.ApusResponse;
import com.google.gson.Gson;

public class JsonFormat {
    public static String convertToJson(Object object){
        return new Gson().toJson(object);
    }

    public static ApusResponse convertToResponse(String apusResponse, Class responseType){
        return (ApusResponse) new Gson().fromJson(apusResponse,responseType);
    }

    public static ApusResponse convertToResponseError(int apusResponse){
        return new ApusResponse(apusResponse,"Erro de conexao");
    }
}
