package com.apus.sdkjava.domain.response;


public class RecurringPaymentResponse extends ApusResponse{
    private Currency currency;
    private BlockChain coin;
    private Transaction transaction;
    private Schedule schedule;

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

    public final Schedule getSchedule() {
        return this.schedule;
    }

    public final void setSchedule( Schedule var1) {
        this.schedule = var1;
    }
}
