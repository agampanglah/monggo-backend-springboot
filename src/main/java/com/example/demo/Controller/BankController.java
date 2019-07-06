package com.example.demo.Controller;


import com.example.demo.Entity.Bank;
import com.example.demo.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {


    @Autowired
    private BankService bankService;

    @RequestMapping(path = "/bank", method = RequestMethod.GET)
    public List<Bank> getBankAll(){
        return bankService.getBankAll();
    }

    @RequestMapping(path = "/bank/{bank_id}", method = RequestMethod.GET)
    public Optional<Bank> getBankById(@PathVariable(value = "bank_id") Long bank_id){
        return bankService.getBankyId(bank_id);
    }

    @RequestMapping(path = "/bank", method = RequestMethod.POST)
    public Bank createBank(@RequestBody Bank bank){
        return bankService.createBank(bank);
    }

    @RequestMapping(path = "/bank/{bank_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bank updateBank(@PathVariable(value = "bank_id") Long bank_id, @RequestBody Bank bank){
        return bankService.updateBankById(bank_id, bank);
    }

    @RequestMapping(path = "/bank/{bank_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBankById(@PathVariable(value = "bank_id") Long bank_id){
        return bankService.deleteById(bank_id);
    }

}
