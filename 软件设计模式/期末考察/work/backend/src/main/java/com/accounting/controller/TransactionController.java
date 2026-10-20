package com.example.accounting.controller;

import com.example.accounting.model.Transaction;
import com.example.accounting.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 事务控制器，提供REST API
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // 添加事务
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    // 更新事务
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    // 删除事务
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "Transaction deleted successfully.";
    }

    // 获取单个事务
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.getTransaction(id);
    }

    // 获取所有事务
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
