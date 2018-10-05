package com.apus.sdkjava.domain.request;

import com.apus.sdkjava.domain.response.BlockChain;
import com.apus.sdkjava.domain.response.Currency;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SearchPayment {

    private String vendorKey;

    private String txId;

    private String timestamp;

    private BlockChain.Type blockchain;

    private Currency.Type currency;

    private String currencyAmount;

    private String coinAmount;

    private String buyer;

    public String getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public BlockChain.Type getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(BlockChain.Type blockchain) {
        this.blockchain = blockchain;
    }

    public Currency.Type getCurrency() {
        return currency;
    }

    public void setCurrency(Currency.Type currency) {
        this.currency = currency;
    }

    public String getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(String currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public String getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(String coinAmount) {
        this.coinAmount = coinAmount;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public static final class Builder {

        private final SearchPayment searchPayment = new SearchPayment();


        public final SearchPayment getSearchPayment() {
            return this.searchPayment;
        }


        public final SearchPayment.Builder withVendorKey( String vendorKey) {
            this.searchPayment.setVendorKey(vendorKey);
            return this;
        }


        public final SearchPayment.Builder withTxId( String txId) {
            this.searchPayment.setTxId(txId);
            return this;
        }


        public final SearchPayment.Builder withTimestamp(long timestamp) {
            this.searchPayment.setTimestamp(String.valueOf(timestamp));
            return this;
        }


        public final SearchPayment.Builder withDate( Date date) {
            this.searchPayment.setTimestamp(String.valueOf(date.getTime()));
            return this;
        }


        public final SearchPayment.Builder withBlockchain( BlockChain.Type blockChain) {
            this.searchPayment.setBlockchain(blockChain);
            return this;
        }


        public final SearchPayment.Builder withCurrency( Currency.Type currency) {
            this.searchPayment.setCurrency(currency);
            return this;
        }


        public final SearchPayment.Builder withCurrencyAmount( String currencyAmount) {
            this.searchPayment.setCurrencyAmount(currencyAmount);
            return this;
        }


        public final SearchPayment.Builder withCoinAmount( String coinAmount) {
            this.searchPayment.setCoinAmount(coinAmount);
            return this;
        }


        public final SearchPayment build() {
            return this.searchPayment;
        }
    }


    public Map toParam() {
        HashMap map = new HashMap();
        String var10000 = getTxId();
        String var2;
        Map var4;
        String var5;
        if (var10000 != null) {
            var2 = var10000;
            var4 = (Map)map;
            var5 = "txId";
            var4.put(var5, var2);
        }

        var10000 = getTimestamp();
        if (var10000 != null) {
            var2 = var10000;
            var4 = (Map)map;
            var5 = "timestamp";
            var4.put(var5, var2);
        }

        BlockChain.Type var10 = getBlockchain();
        String var6;
        if (var10 != null) {
            BlockChain.Type var8 = var10;
            var4 = (Map)map;
            var5 = "blockchain";
            var6 = var8.toString();
            var4.put(var5, var6);
        }

        Currency.Type var11 = getCurrency();
        if (var11 != null) {
            Currency.Type var9 = var11;
            var4 = (Map)map;
            var5 = "currency";
            var6 = var9.toString();
            var4.put(var5, var6);
        }

        var10000 = getCurrencyAmount();
        if (var10000 != null) {
            var2 = var10000;
            var4 = (Map)map;
            var5 = "currencyAmount";
            var4.put(var5, var2);
        }

        var10000 = getCoinAmount();
        if (var10000 != null) {
            var2 = var10000;
            var4 = (Map)map;
            var5 = "coinAmount";
            var4.put(var5, var2);
        }

        var10000 = getBuyer();
        if (var10000 != null) {
            var2 = var10000;
            var4 = (Map)map;
            var5 = "buyer";
            var4.put(var5, var2);
        }

        return (Map)map;
    }
}
