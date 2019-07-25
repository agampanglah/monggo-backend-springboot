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

    private Integer jumlah_transaksi;
    private String nama_bank_pengirim;
    private String no_rek_pengirim;
    private String status;
    private Date tanggal_invoice;
    private String status_bukti_pembayaran;
    private Date tanggal_pembayaran;
    private Integer jumlah_lot;

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

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(Integer jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
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

    public Date getTanggal_invoice() {
        return tanggal_invoice;
    }

    public void setTanggal_invoice(Date tanggal_invoice) {
        this.tanggal_invoice = tanggal_invoice;
    }

    public String getStatus_bukti_pembayaran() {
        return status_bukti_pembayaran;
    }

    public void setStatus_bukti_pembayaran(String status_bukti_pembayaran) {
        this.status_bukti_pembayaran = status_bukti_pembayaran;
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
