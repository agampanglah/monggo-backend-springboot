package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false, length = 15)
    private Long product_id;

    @NotBlank(message = "please input column")
    private String nama_product;


    private  String foto ;

    private Integer price;

    private Integer lot;

    @OneToMany(mappedBy = "product")
    Set<Transaction> transactionEntities  = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "wilayah_id")
    Wilayah wilayah;


    public Product() {
    }

    public Product(@NotBlank(message = "please input column") String nama_product, Integer price, String foto, Integer lot)
    {
        this.nama_product = nama_product;
        this.price = price;
        this.foto = foto;
        this.lot = lot;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getNama_product() {
        return nama_product;
    }

    public void setNama_product(String nama_product) {
        this.nama_product = nama_product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }
}
