package com.example.demo.Dao;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName (RoleName role);
}
