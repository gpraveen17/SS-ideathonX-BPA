package org.statestreet.beans;

public class BalanceSheet {

    private int id;
    private String productName;
    private double amount;
    private String productType;
    private int processId;

    public BalanceSheet(Builder builder) {
        this.id = builder.id;
        this.productName = builder.productName;
        this.amount = builder.amount;
        this.productType = builder.productType;
        this.processId = builder.processId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", productType='" + productType + '\'' +
                ", processId=" + processId +
                '}';
    }

    public static final class Builder {

        private int id;
        private String productName;
        private double amount;
        private String productType;
        private int processId;

        public Builder() {

        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }

        public Builder processId(int processId) {
            this.processId = processId;
            return this;
        }

        public  BalanceSheet build(){
            return new BalanceSheet(this);
        }

    }
}
