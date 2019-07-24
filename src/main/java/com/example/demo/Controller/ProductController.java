package com.example.demo.Controller;


import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Wilayah;
import com.example.demo.Service.BankService;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/product", method = RequestMethod.GET)
    public List<Product> getProductAll(){
        return productService.getProductAll();
    }

    @RequestMapping(path = "/product/{product_id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable(value = "product_id") Long product_id){
        return productService.getProductById(product_id);
    }

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @RequestMapping(path = "/product/{product_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProductById(@PathVariable(value = "product_id") Long product_id, @RequestBody Product product){
        return productService.updateProductById(product_id, product);
    }

    @RequestMapping(path = "/product/{product_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProductById(@PathVariable(value = "product_id") Long product_id){
        return productService.deleteById(product_id);
    }

}
