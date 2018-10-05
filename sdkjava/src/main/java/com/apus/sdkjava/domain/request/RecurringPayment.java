package com.apus.sdkjava.domain.request;

import com.apus.sdkjava.common.DataFormat;
import com.apus.sdkjava.domain.response.BlockChain;
import com.apus.sdkjava.domain.response.Currency;
import com.apus.sdkjava.domain.response.Period;

public class RecurringPayment {

    private String pan;

    private String password;

    private BlockChain.Type blockchain;

    private String amount;

    private Currency.Type currency;

    private Period period;
    private int frequency;
    private boolean execute;

    private String vendorKey;


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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isExecute() {
        return execute;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    public String getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    public static final class Builder {

        private final RecurringPayment recurringPayment = new RecurringPayment();


        public final RecurringPayment getRecurringPayment() {
            return this.recurringPayment;
        }


        public final RecurringPayment.Builder withPeriod( Period period) {
            this.recurringPayment.setPeriod(period);
            return this;
        }


        public final RecurringPayment.Builder withFrequency(int frequency) {
            return this;
        }


        public final RecurringPayment.Builder withExecute(boolean execute) {
            return this;
        }


        public final RecurringPayment.Builder withPan( String pan) {
            this.recurringPayment.setPan(DataFormat.toSha256(pan));
            return this;
        }


        public final RecurringPayment.Builder withPassWord( String password) {
            this.recurringPayment.setPassword(DataFormat.toSha256(password));
            return this;
        }


        public final RecurringPayment.Builder withPanEncrypted( String pan) {
            this.recurringPayment.setPan(pan);
            return this;
        }


        public final RecurringPayment.Builder withPassWordEncrypted( String password) {
            this.recurringPayment.setPassword(password);
            return this;
        }


        public final RecurringPayment.Builder withBlockChain( BlockChain.Type blockChain) {
            this.recurringPayment.setBlockchain(blockChain);
            return this;
        }


        public final RecurringPayment.Builder withAmount( String amount) {
            this.recurringPayment.setAmount(amount.replaceAll("[a-z,A-Z]*", ""));

            return this;
        }


        public final RecurringPayment.Builder withAmount(int amount) {
            return this.withAmount(String.valueOf(amount));
        }


        public final RecurringPayment.Builder withCurrency( Currency.Type currency) {
            this.recurringPayment.setCurrency(currency);
            return this;
        }


        public final RecurringPayment.Builder withVendorKey( String vendorKey) {
            this.recurringPayment.setVendorKey(vendorKey);
            return this;
        }


        public final RecurringPayment build() {
            return this.recurringPayment;
        }
    }
}
