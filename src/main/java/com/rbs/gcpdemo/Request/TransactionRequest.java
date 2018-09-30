package com.rbs.gcpdemo.Request;

public class TransactionRequest {

    private String clientTransactionId;
    private int clientId;
    private int rateQuoteId;
    private int dealtAmount;

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getRateQuoteId() {
        return rateQuoteId;
    }

    public void setRateQuoteId(int rateQuoteId) {
        this.rateQuoteId = rateQuoteId;
    }

    public int getDealtAmount() {
        return dealtAmount;
    }

    public void setDealtAmount(int dealtAmount) {
        this.dealtAmount = dealtAmount;
    }
}
