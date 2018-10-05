package com.apus.sdkjava.domain.request;


import com.apus.sdkjava.common.DataFormat;

public class CancelPayment {
    private String password;
    private String txId;
    private String vendorKey;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    public static final class Builder {

        private final CancelPayment cancelPayment = new CancelPayment();


        public final CancelPayment getCancelPayment() {
            return this.cancelPayment;
        }


        public final CancelPayment.Builder withPassWord( String password) {

            this.cancelPayment.setPassword(DataFormat.toSha256(password));
            return this;
        }


        public final CancelPayment.Builder withPassWordEncrypted( String password) {

            this.cancelPayment.setPassword(password);
            return this;
        }


        public final CancelPayment.Builder withTxId( String txId) {
            this.cancelPayment.setTxId(txId);
            return this;
        }


        public final CancelPayment.Builder withVendorKey( String vendorKey) {
            this.cancelPayment.setVendorKey(vendorKey);
            return this;
        }


        public final CancelPayment build() {
            return this.cancelPayment;
        }
    }
}

