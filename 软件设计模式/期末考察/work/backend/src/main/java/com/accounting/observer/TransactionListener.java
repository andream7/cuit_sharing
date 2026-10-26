// TransactionListener.java
package com.example.accounting.observer;

import com.example.accounting.model.Transaction;

/**
 * 事务监听器接口，应用观察者模式
 */
public interface TransactionListener {
    void onTransactionAdded(Transaction transaction);
    void onTransactionUpdated(Transaction transaction);
    void onTransactionDeleted(Long id, Transaction transaction);
}
