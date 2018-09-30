package com.rbs.gcpdemo.entity;

import com.rbs.gcpdemo.Request.TransactionResponse;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "TRANSACTION")
public class  Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    public Transaction() {
    }

    public Transaction(Client client, RateQuote rateQuote, String clientTransactionId, int amount) {
        this.client = client;
        this.rateQuote = rateQuote;
        this.clientTransactionId = clientTransactionId;
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "rateQuoteId")
    private RateQuote rateQuote;

    private String clientTransactionId;

    private int amount;

    public int getTransactionId() {
        return transactionId;
    }

    public Client getClient() {
        return client;
    }

    public RateQuote getRateQuote() {
        return rateQuote;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public int getAmount() {
        return amount;
    }


}
