package com.example.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wilayah")
public class Wilayah implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long wilayah_id ;

    private String nama_wilayah;

    @OneToMany( mappedBy = "wilayah")
    Set<Product> productEntities = new HashSet<>();

    public Wilayah(Long wilayah_id, String nama_wilayah) {
        this.wilayah_id = wilayah_id;
        this.nama_wilayah = nama_wilayah;
    }

    public Long getWilayah_id() {
        return wilayah_id;
    }

    public void setWilayah_id(Long wilayah_id) {
        this.wilayah_id = wilayah_id;
    }

    public String getNama_wilayah() {
        return nama_wilayah;
    }

    public void setNama_wilayah(String nama_wilayah) {
        this.nama_wilayah = nama_wilayah;
    }
}
