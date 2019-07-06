package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank")

public class Bank implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long bank_id;

    @NotBlank(message = "must fill in")
    private String nama_bank;


    @OneToMany(mappedBy = "bank")
    Set<Transaction> transactionEntities= new HashSet<>();


    public Bank() {
    }


    public Long getBank_id() {
        return bank_id;
    }

    public void setBank_id(Long bank_id) {
        this.bank_id = bank_id;
    }

    public String getNama_bank() {
        return nama_bank;
    }

    public void setNama_bank(String nama_bank) {
        this.nama_bank = nama_bank;
    }
}
