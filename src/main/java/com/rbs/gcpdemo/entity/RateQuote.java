package com.rbs.gcpdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "RATE_QUOTE")
public class RateQuote implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rateQuoteId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    private String buyCurrency;
    private String sellCurrency;

    private double rate;

    public int getRateQuoteId() {
        return rateQuoteId;
    }

    public void setRateQuoteId(int rateQuoteId) {
        this.rateQuoteId = rateQuoteId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public String getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }

    public String getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }


}
