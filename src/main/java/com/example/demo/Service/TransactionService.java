package com.example.demo.Service;

import com.example.demo.Dao.BankDao;
import com.example.demo.Dao.TrasanctionDao;
import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TransactionService {


    @Autowired
    private TrasanctionDao trasanctionDao;

    public List<Transaction> getTransactionAll(){
        return trasanctionDao.findAll();
    }

    public Optional<Transaction> getTransactionId(Long transaction_id) {
        if (trasanctionDao.existsById(transaction_id)) {

            return trasanctionDao.findById(transaction_id);
        }
        else{
            throw new ResourceNotFoundException("transaction dengan " + transaction_id + "tidak ditemukan");
        }

    }

    public Transaction createTransaction(Transaction transaction){
        return trasanctionDao.save(transaction);
    }

    public Transaction updateTransactionById(Long transaction_id, Transaction transactionRequest){
        if (!trasanctionDao.existsById(transaction_id)){
            throw new ResourceNotFoundException("transaction dengan"  + transaction_id + "tidak ditemukan");
        }

        Optional<Transaction> transaction = trasanctionDao.findById(transaction_id);

        if (!(transaction.isPresent())){
            throw new ResourceNotFoundException("transaction dengan"  + transaction_id + "tidak ditemukan");
        }

        Transaction transaction1 = transaction.get();
        transaction1.setJumlah_lot(transactionRequest.getJumlah_lot());
        transaction1.setJumlah_transaksi(transactionRequest.getJumlah_transaksi());
        transaction1.setNama_bank_pengirim(transactionRequest.getNama_bank_pengirim());
        transaction1.setNo_rek_pengirim(transactionRequest.getNo_rek_pengirim());
        transaction1.setStatus(transactionRequest.getStatus());
        transaction1.setStatus_bukti_pembayaran(transactionRequest.getStatus_bukti_pembayaran());
        transaction1.setTanggal_invoice(transactionRequest.getTanggal_invoice());
        transaction1.setTanggal_pembayaran(transactionRequest.getTanggal_pembayaran());
        transaction1.setTransaction_id(transactionRequest.getTransaction_id());


        return trasanctionDao.save(transaction1);
    }

    public ResponseEntity<Object> deleteById(Long transaction_id){
        if (!trasanctionDao.existsById(transaction_id)){
            throw new ResourceNotFoundException("transaksi dengan"  + transaction_id + "tidak ditemukan");
        }

        trasanctionDao.deleteById(transaction_id);
        return ResponseEntity.ok().build();
    }
}
