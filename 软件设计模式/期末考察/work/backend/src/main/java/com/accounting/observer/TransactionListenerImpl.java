// TransactionListenerImpl.java
package com.example.accounting.observer;

import com.example.accounting.model.Transaction;
import org.springframework.stereotype.Component;

/**
 * 事务监听器实现类，记录操作日志
 */
@Component
public class TransactionListenerImpl implements TransactionListener {

    @Override
    public void onTransactionAdded(Transaction transaction) {
        System.out.println("事务添加: " + transaction.getId() + ", 类型: " + transaction.getType() + ", 金额: " + transaction.getAmount());
    }

    @Override
    public void onTransactionUpdated(Transaction transaction) {
        System.out.println("事务更新: " + transaction.getId() + ", 类型: " + transaction.getType() + ", 金额: " + transaction.getAmount());
    }

    @Override
    public void onTransactionDeleted(Long id, Transaction transaction) {
        System.out.println("事务删除: " + id + ", 类型: " + transaction.getType() + ", 金额: " + transaction.getAmount());
    }
}
