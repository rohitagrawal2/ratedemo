package com.rbs.gcpdemo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 40)
    private String emailId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;

    private long segmentId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public long getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(long segmentId) {
        this.segmentId = segmentId;
    }
}
