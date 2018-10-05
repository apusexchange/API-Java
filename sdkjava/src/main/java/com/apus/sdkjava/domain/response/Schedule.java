package com.apus.sdkjava.domain.response;



public class Schedule {
    private Period period;
    private int frequency;
    private boolean execute;
    private String id;

    public final Period getPeriod() {
        return this.period;
    }

    public final void setPeriod( Period var1) {
        this.period = var1;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final void setFrequency(int var1) {
        this.frequency = var1;
    }

    public final boolean getExecute() {
        return this.execute;
    }

    public final void setExecute(boolean var1) {
        this.execute = var1;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId( String var1) {
        this.id = var1;
    }
}