package com.example.demo.Dao;

import com.example.demo.Entity.Wilayah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WilayahDao extends JpaRepository<Wilayah, Long> {
}
