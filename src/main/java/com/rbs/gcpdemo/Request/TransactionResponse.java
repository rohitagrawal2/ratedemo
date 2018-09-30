package com.rbs.gcpdemo.Request;

public class TransactionResponse {

    private int transactionId;
    private String clientTransactionId;
    private double rate;
    private int buyAmount;
    private double sellAmount;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(double sellAmount) {
        this.sellAmount = sellAmount;
    }
}
