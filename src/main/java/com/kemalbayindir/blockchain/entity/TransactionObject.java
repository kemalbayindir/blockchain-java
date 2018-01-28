package com.kemalbayindir.blockchain.entity;

/**
 * Created by kemalbayindir on 28.01.2018.
 */
public class TransactionObject {
    private String from;
    private String to;
    private Long   amount;

    public TransactionObject(String from, String to, Long amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Block[from:" + this.from + ", to:" + this.to + ", amount:" + this.amount +"]";
    }
}
