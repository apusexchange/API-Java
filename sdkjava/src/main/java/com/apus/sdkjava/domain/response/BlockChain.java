package com.apus.sdkjava.domain.response;

public class BlockChain {
    public String name;
    public String amount;
    public String fee;

    public enum Type{
        BTC, LTC, ETH, DCR
    }
}
