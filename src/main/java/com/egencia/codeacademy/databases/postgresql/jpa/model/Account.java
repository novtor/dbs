package com.egencia.codeacademy.databases.postgresql.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "account")
@Table(name = "account")
@SequenceGenerator(name="account_seq", sequenceName = "id_generator", allocationSize = 50)
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @Column(name = "account_id")
    private Long id;

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
