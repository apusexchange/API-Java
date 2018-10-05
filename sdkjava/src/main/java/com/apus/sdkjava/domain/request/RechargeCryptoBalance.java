package com.apus.sdkjava.domain.request;

import com.apus.sdkjava.common.DataFormat;
import com.apus.sdkjava.domain.response.BlockChain;
import com.apus.sdkjava.domain.response.Currency;


public class RechargeCryptoBalance {

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

        private final RechargeCryptoBalance rechargeCryptoBalance = new RechargeCryptoBalance();


        public final RechargeCryptoBalance getRechargeCryptoBalance() {
            return this.rechargeCryptoBalance;
        }


        public final RechargeCryptoBalance.Builder withPan( String pan) {
            this.rechargeCryptoBalance.setPan(DataFormat.toSha256(pan));
            return this;
        }


        public final RechargeCryptoBalance.Builder withPassWord( String password) {
            this.rechargeCryptoBalance.setPassword(DataFormat.toSha256(password));
            return this;
        }


        public final RechargeCryptoBalance.Builder withPanEncrypted( String pan) {
            this.rechargeCryptoBalance.setPan(pan);
            return this;
        }


        public final RechargeCryptoBalance.Builder withPassWordEncrypted( String password) {
            this.rechargeCryptoBalance.setPassword(password);
            return this;
        }


        public final RechargeCryptoBalance.Builder withBlockChain( BlockChain.Type blockChain) {
            this.rechargeCryptoBalance.setBlockchain(blockChain);
            return this;
        }


        public final RechargeCryptoBalance.Builder withAmount( String amount) {
            this.rechargeCryptoBalance.setAmount(amount.replaceAll("[a-z,A-Z]*",""));

            return this;
        }


        public final RechargeCryptoBalance.Builder withAmount(int amount) {
            return this.withAmount(String.valueOf(amount));
        }


        public final RechargeCryptoBalance.Builder withCurrency( Currency.Type currency) {
            this.rechargeCryptoBalance.setCurrency(currency);
            return this;
        }


        public final RechargeCryptoBalance.Builder withVendorKey( String vendorKey) {
            this.rechargeCryptoBalance.setVendorKey(vendorKey);
            return this;
        }


        public final RechargeCryptoBalance build() {
            return this.rechargeCryptoBalance;
        }
    }
}
