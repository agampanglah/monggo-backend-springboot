package com.example.demo.Controller;


import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Transaction;
import com.example.demo.Service.BankService;
import com.example.demo.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(path = "/transaction", method = RequestMethod.GET)
    public List<Transaction> getTransactionAll(){
        return transactionService.getTransactionAll();
    }

    @RequestMapping(path = "/transaction/{transaction_id}", method = RequestMethod.GET)
    public Optional<Transaction> getTransactionById(@PathVariable(value = "transaction_id") Long transaction_id){
        return transactionService.getTransactionId(transaction_id);
    }

    @RequestMapping(path = "/transaction", method = RequestMethod.POST)
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.createTransaction(transaction);
    }

    @RequestMapping(path = "/transaction/{transaction_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Transaction updateTransactionById(@PathVariable(value = "transaction_id") Long transaction_id, @RequestBody Transaction transaction){
        return transactionService.updateTransactionById(transaction_id, transaction);
    }

    @RequestMapping(path = "/transaction/{transaction_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTransactionById(@PathVariable(value = "transaction_id") Long transaction_id){
        return transactionService.deleteById(transaction_id);
    }
}
