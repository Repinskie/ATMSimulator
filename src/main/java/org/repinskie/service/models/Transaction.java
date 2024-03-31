package org.repinskie.service.models;

import java.util.Date;

public class Transaction {
    private Long id;
    private String senderName;
    private String senderSurName;
    private String recipientName;
    private String recipientSurName;
    private double amount;
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(String senderName, String senderSurName, String recipientName, String recipientSurName, double amount, Date transactionDate) {
        this.senderName = senderName;
        this.senderSurName = senderSurName;
        this.recipientName = recipientName;
        this.recipientSurName = recipientSurName;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Transaction(Long id, String senderName, String recipientName, double amount, Date transactionDate) {
        this.id = id;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderSurName() {
        return senderSurName;
    }

    public void setSenderSurName(String senderSurName) {
        this.senderSurName = senderSurName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurName() {
        return recipientSurName;
    }

    public void setRecipientSurName(String recipientSurName) {
        this.recipientSurName = recipientSurName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date date) {
        this.transactionDate = date;
    }
}
