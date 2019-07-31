package com.example.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long transaction_id;


    private String nama_bank_pengirim;
    private String no_rek_pengirim;
    private String status;
    private String bukti_pembayaran;
    private Date tanggal_pembayaran;
    private Integer jumlah_lot;
    private Integer jumlah_harga;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    Bank bank;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;


    public Transaction() {
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }



    public String getNama_bank_pengirim() {
        return nama_bank_pengirim;
    }

    public void setNama_bank_pengirim(String nama_bank_pengirim) {
        this.nama_bank_pengirim = nama_bank_pengirim;
    }

    public String getNo_rek_pengirim() {return no_rek_pengirim; }

    public void setNo_rek_pengirim(String no_rek_pengirim) {
        this.no_rek_pengirim = no_rek_pengirim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getBukti_pembayaran() {
        return bukti_pembayaran;
    }

    public void setBukti_pembayaran(String bukti_pembayaran) {
        this.bukti_pembayaran = bukti_pembayaran;
    }

    public Integer getJumlah_harga() {
        return jumlah_harga;
    }

    public void setJumlah_harga(Integer jumlah_harga) {
        this.jumlah_harga = jumlah_harga;
    }

    public Date getTanggal_pembayaran() {
        return tanggal_pembayaran;
    }

    public void setTanggal_pembayaran(Date tanggal_pembayaran) {
        this.tanggal_pembayaran = tanggal_pembayaran;
    }

    public Integer getJumlah_lot() {
        return jumlah_lot;
    }

    public void setJumlah_lot(Integer jumlah_lot) {
        this.jumlah_lot = jumlah_lot;
    }
}
