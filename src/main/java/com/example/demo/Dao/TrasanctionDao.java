package com.example.demo.Dao;

import com.example.demo.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasanctionDao extends JpaRepository<Transaction, Long> {
}
