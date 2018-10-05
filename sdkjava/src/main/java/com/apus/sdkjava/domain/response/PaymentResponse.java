package com.apus.sdkjava.domain.response;


public class PaymentResponse extends ApusResponse {
    private Currency currency;
    private BlockChain coin;
    private Transaction transaction;


    public final Currency getCurrency() {
        return this.currency;
    }

    public final void setCurrency( Currency var1) {
        this.currency = var1;
    }

    public final BlockChain getCoin() {
        return this.coin;
    }

    public final void setCoin( BlockChain var1) {
        this.coin = var1;
    }

    public final Transaction getTransaction() {
        return this.transaction;
    }

    public final void setTransaction( Transaction var1) {
        this.transaction = var1;
    }
}
