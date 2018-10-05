package com.apus.sdkjava.domain.response;

public class ApusResponse {
    private Status status;


    public ApusResponse(int apusResponse, String erro_de_conexao) {
        this.status = new Status(apusResponse,erro_de_conexao);
    }

    public ApusResponse(Status status) {
        this.status = status;
    }

    public ApusResponse() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public class Status {
        int code;
        String message;

        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
