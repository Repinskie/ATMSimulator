package org.repinskie.service;

import java.time.LocalDateTime;

public class Transaction {
    private String sender;
    private String receiver;
    private double amount;
    private LocalDateTime localDateTime;

    public Transaction(String sender, String receiver, double amount, LocalDateTime localDateTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.localDateTime = localDateTime;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
