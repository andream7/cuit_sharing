// src/main/java/com/example/accounting/model/Transaction.java
package com.example.accounting.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // INCOME 或 EXPENSE

    private Double amount;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // 构造方法
    public Transaction() {}

    public Transaction(String type, Double amount, String description, Date date) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getter 和 Setter
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
