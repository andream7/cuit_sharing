// TransactionService.java
package com.example.accounting.service;

import com.example.accounting.model.Transaction;

import java.util.List;

/**
 * 事务服务接口
 */
public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    Transaction updateTransaction(Long id, Transaction transaction);
    void deleteTransaction(Long id);
    Transaction getTransaction(Long id);
    List<Transaction> getAllTransactions();
}
