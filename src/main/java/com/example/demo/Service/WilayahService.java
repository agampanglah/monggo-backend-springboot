package com.example.demo.Service;


import com.example.demo.Dao.ProductDao;
import com.example.demo.Dao.WilayahDao;
import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Wilayah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WilayahService {

    @Autowired
    private WilayahDao wilayahDao;

    public List<Wilayah> getWilayahAll(){
        return wilayahDao.findAll();
    }

    public Optional<Wilayah> getWilayahById(Long wilayah_id) {
        if (wilayahDao.existsById(wilayah_id)) {

            return wilayahDao.findById(wilayah_id);
        }
        else{
            throw new ResourceNotFoundException("wilayaht dengan " + wilayah_id + "tidak ditemukan");
        }

    }

    public Wilayah createWilayah(Wilayah wilayah){
        return wilayahDao.save(wilayah);
    }

    public Wilayah updateWilayahById(Long wilayah_id, Wilayah wilayahRequest){
        if (!wilayahDao.existsById(wilayah_id)){
            throw new ResourceNotFoundException("wilayah dengan"  + wilayah_id + "tidak ditemukan");
        }

        Optional<Wilayah> wilayah = wilayahDao.findById(wilayah_id);

        if (!wilayah.isPresent()){
            throw new ResourceNotFoundException("wilayah dengan"  + wilayah_id + "tidak ditemukan");
        }

        Wilayah wilayah1 = wilayah.get();
        wilayah1.setNama_wilayah(wilayahRequest.getNama_wilayah());
        wilayah1.setWilayah_id(wilayahRequest.getWilayah_id());

        return wilayahDao.save(wilayah1);
    }

    public ResponseEntity<Object> deleteById(Long wilayah_id){
        if (!wilayahDao.existsById(wilayah_id)){
            throw new ResourceNotFoundException("wilayah dengan"  + wilayah_id + "tidak ditemukan");
        }

        wilayahDao.deleteById(wilayah_id);
        return ResponseEntity.ok().build();
    }

//    public ResponseEntity<Object> getProductByIdWilayah(Long produc){
//        if ((wilayah_id.equals()))
//    }
}
