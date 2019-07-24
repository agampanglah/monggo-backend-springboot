package com.example.demo.Service;


import com.example.demo.Dao.ProductDao;
import com.example.demo.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductDao productDao;

    public List<Product> getProductAll(){
        return productDao.findAll();
    }

    public Optional<Product> getProductById(Long product_id) {
        if (productDao.existsById(product_id)) {

            return productDao.findById(product_id);
        }
        else{
            throw new ResourceNotFoundException("product dengan " + product_id + "tidak ditemukan");
        }

    }

    public Product createProduct(Product product){
        return productDao.save(product);
    }

    public Product updateProductById(Long product_id, Product productRequest){
        if (!productDao.existsById(product_id)){
            throw new ResourceNotFoundException("product dengan"  + product_id + "tidak ditemukan");
        }

        Optional<Product> product = productDao.findById(product_id);

        if (!product.isPresent()){
            throw new ResourceNotFoundException("product dengan"  + product + "tidak ditemukan");
        }

        Product product1 = product.get();
        product1.setNama_product(productRequest.getNama_product());
        product1.setProduct_id(productRequest.getProduct_id());
        product1.setPrice(productRequest.getPrice());
        product1.setFoto(productRequest.getFoto());
        product1.setLot(productRequest.getLot());
        return productDao.save(product1);
    }

    public ResponseEntity<Object> deleteById(Long product_id){
        if (!productDao.existsById(product_id)){
            throw new ResourceNotFoundException("Mahasiswa dengan"  + product_id + "tidak ditemukan");
        }

        productDao.deleteById(product_id);
        return ResponseEntity.ok().build();
    }
}
