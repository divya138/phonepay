package com.hcl.phonepaytransaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.phonepaytransaction.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
