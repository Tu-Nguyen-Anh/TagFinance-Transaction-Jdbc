package com.example.demo.dao;

import com.example.demo.data.entity.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAllTransactions();

    Transaction insertTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction, int id) ;

    void deleteTransaction(int id);


}
