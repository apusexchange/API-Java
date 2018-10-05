package com.apus.sdkjava.domain.response;



public class SearchResponse extends ApusResponse {
    private Data[] data;

    public Data[] getData() {
        return this.data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public class Data {
        private Buyer buyer;
        private BlockChain coin;
        private Currency currency;
        private Seller seller;
        private String txId;

        public final Buyer getBuyer() {
            return this.buyer;
        }

        public final void setBuyer( Buyer var1) {
            this.buyer = var1;
        }

        public final BlockChain getCoin() {
            return this.coin;
        }

        public final void setCoin( BlockChain var1) {
            this.coin = var1;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final void setCurrency( Currency var1) {
            this.currency = var1;
        }

        public final Seller getSeller() {
            return this.seller;
        }

        public final void setSeller( Seller var1) {
            this.seller = var1;
        }

        public final String getTxId() {
            return this.txId;
        }

        public final void setTxId( String var1) {
            this.txId = var1;
        }
    }
}
