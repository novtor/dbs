package com.egencia.codeacademy.databases.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.math.BigDecimal;

public class Account {

    @Id
    private String id;

    private BigDecimal amount;

    @Version
    private int version;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                ", version=" + version +
                '}';
    }
}
