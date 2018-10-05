package com.apus.sdkjava.domain.response;


public class Transaction {
    private String txId;
    private Long timestamp;
    private String buyer;

    public final String getTxId() {
        return this.txId;
    }

    public final void setTxId( String var1) {
        this.txId = var1;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp( Long var1) {
        this.timestamp = var1;
    }

    public final String getBuyer() {
        return this.buyer;
    }

    public final void setBuyer( String var1) {
        this.buyer = var1;
    }
}
