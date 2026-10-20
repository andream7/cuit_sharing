// TransactionServiceImpl.java
package com.example.accounting.service;

import com.example.accounting.model.Transaction;
import com.example.accounting.repository.TransactionRepository;
import com.example.accounting.observer.TransactionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 事务服务实现类，应用观察者模式
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private List<TransactionListener> listeners; // Spring自动注入所有TransactionListener

    @Override
    public Transaction addTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        // 通知监听器
        for (TransactionListener listener : listeners) {
            listener.onTransactionAdded(savedTransaction);
        }
        return savedTransaction;
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (optional.isPresent()) {
            Transaction existing = optional.get();
            existing.setType(transaction.getType());
            existing.setAmount(transaction.getAmount());
            existing.setDescription(transaction.getDescription());
            existing.setDate(transaction.getDate());
            Transaction updated = transactionRepository.save(existing);
            // 通知监听器
            for (TransactionListener listener : listeners) {
                listener.onTransactionUpdated(updated);
            }
            return updated;
        } else {
            throw new RuntimeException("Transaction not found with id " + id);
        }
    }

    @Override
    public void deleteTransaction(Long id) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (optional.isPresent()) {
            Transaction transaction = optional.get();
            transactionRepository.deleteById(id);
            // 通知监听器
            for (TransactionListener listener : listeners) {
                listener.onTransactionDeleted(id, transaction);
            }
        } else {
            throw new RuntimeException("Transaction not found with id " + id);
        }
    }

    @Override
    public Transaction getTransaction(Long id) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Transaction not found with id " + id);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
