// src/test/java/com/example/accounting/repository/TransactionRepositoryTest.java
package com.example.accounting.repository;

import com.example.accounting.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testAddTransaction() {
        Transaction transaction = new Transaction("INCOME", 1500.0, "Freelance Work", new Date());
        Transaction savedTransaction = transactionRepository.save(transaction);
        assertNotNull(savedTransaction.getId());
    }

    @Test
    public void testGetAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        assertNotNull(transactions);
    }

    @Test
    public void testUpdateTransaction() {
        Transaction transaction = new Transaction("EXPENSE", 200.0, "Groceries", new Date());
        Transaction savedTransaction = transactionRepository.save(transaction);
        savedTransaction.setAmount(250.0);
        Transaction updatedTransaction = transactionRepository.save(savedTransaction);
        assertEquals(250.0, updatedTransaction.getAmount());
    }

    @Test
    public void testDeleteTransaction() {
        Transaction transaction = new Transaction("INCOME", 1000.0, "Salary", new Date());
        Transaction savedTransaction = transactionRepository.save(transaction);
        Long id = savedTransaction.getId();
        transactionRepository.deleteById(id);
        assertFalse(transactionRepository.findById(id).isPresent());
    }
}
