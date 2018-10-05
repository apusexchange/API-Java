package com.apus.sdkjava.domain.request;


import com.apus.sdkjava.common.DataFormat;
import com.apus.sdkjava.domain.response.BlockChain;
import com.apus.sdkjava.domain.response.Currency;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class MakePayment {
    public String pan;
    public String password;
    public BlockChain.Type blockchain;
    public String amount;
    public Currency.Type currency;
    public String vendorKey;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BlockChain.Type getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(BlockChain.Type blockchain) {
        this.blockchain = blockchain;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Currency.Type getCurrency() {
        return currency;
    }

    public void setCurrency(Currency.Type currency) {
        this.currency = currency;
    }

    public String getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    public static final class Builder {
        private final MakePayment makePayment = new MakePayment();

        public final MakePayment getMakePayment() {
            return this.makePayment;
        }

        public final MakePayment.Builder withPan( String pan) {

            this.makePayment.setPan(DataFormat.toSha256(pan));
            return this;
        }

        public final MakePayment.Builder withPassWord( String password) {
            this.makePayment.setPassword(DataFormat.toSha256(password));
            return this;
        }

        public final MakePayment.Builder withPanEncrypted( String pan) {
            this.makePayment.setPan(pan);
            return this;
        }

        public final MakePayment.Builder withPassWordEncrypted( String password) {
            this.makePayment.setPassword(password);
            return this;
        }

        public final MakePayment.Builder withBlockChain( BlockChain.Type blockChain) {
            this.makePayment.setBlockchain(blockChain);
            return this;
        }

        public final MakePayment.Builder withAmount( String amount) {
            makePayment.setAmount(amount.replaceAll("[a-z,A-Z]*",""));
            return this;
        }

        public final MakePayment.Builder withAmount(int amount) {
            return this.withAmount(String.valueOf(amount));
        }

        public final MakePayment.Builder withCurrency( Currency.Type currency) {
            this.makePayment.setCurrency(currency);
            return this;
        }

        public final MakePayment.Builder withVendorKey( String vendorKey) {
            this.makePayment.setVendorKey(vendorKey);
            return this;
        }


        public final MakePayment build() {
            return this.makePayment;
        }
    }
}
