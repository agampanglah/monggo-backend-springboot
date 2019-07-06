package com.example.demo.Service;


import com.example.demo.Dao.BankDao;
import com.example.demo.Dao.ProductDao;
import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankDao bankDao;

    public List<Bank> getBankAll(){
        return bankDao.findAll();
    }

    public Optional<Bank> getBankyId(Long bank_id) {
        if (bankDao.existsById(bank_id)) {

            return bankDao.findById(bank_id);
        }
        else{
            throw new ResourceNotFoundException("bank dengan " + bank_id + "tidak ditemukan");
        }

    }

    public Bank createBank(Bank bank){
        return bankDao.save(bank);
    }

    public Bank updateBankById(Long bank_id, Bank bankRequest){
        if (!bankDao.existsById(bank_id)){
            throw new ResourceNotFoundException("bank dengan"  + bank_id + "tidak ditemukan");
        }

        Optional<Bank> bank = bankDao.findById(bank_id);

        if (!bank.isPresent()){
            throw new ResourceNotFoundException("bank dengan"  + bank_id + "tidak ditemukan");
        }

        Bank bank1 = bank.get();
        bank1.setBank_id(bankRequest.getBank_id());
        bank1.setNama_bank(bankRequest.getNama_bank());

        return bankDao.save(bank1);
    }

    public ResponseEntity<Object> deleteById(Long bank_id){
        if (!bankDao.existsById(bank_id)){
            throw new ResourceNotFoundException("Mahasiswa dengan"  + bank_id + "tidak ditemukan");
        }

        bankDao.deleteById(bank_id);
        return ResponseEntity.ok().build();
    }
}
