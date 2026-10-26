package com.example.accounting.repository;

import com.example.accounting.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 事务Repository接口，继承JPA Repository
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // 可以添加自定义查询方法
}
