package com.example.demo.Controller;


import com.example.demo.Entity.Bank;
import com.example.demo.Entity.Wilayah;
import com.example.demo.Service.BankService;
import com.example.demo.Service.WilayahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class WilayahController {



    @Autowired
    private WilayahService wilayahService;

    @RequestMapping(path = "/wilayah", method = RequestMethod.GET)
    public List<Wilayah> getwilayahAll(){
        return wilayahService.getWilayahAll();
    }

    @RequestMapping(path = "/wilayah/{wilayah_id}", method = RequestMethod.GET)
    public Optional<Wilayah> getBankById(@PathVariable(value = "wilayah_id") Long wilayah_id){
        return wilayahService.getWilayahById(wilayah_id);
    }

    @RequestMapping(path = "/wilayah", method = RequestMethod.POST)
    public Wilayah createWilayah(@RequestBody Wilayah wilayah){
        return wilayahService.createWilayah(wilayah);
    }

    @RequestMapping(path = "/wilayah/{wilayah_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Wilayah updateWilayah(@PathVariable(value = "wilayah_id") Long wilayah_id, @RequestBody Wilayah wilayah){
        return wilayahService.updateWilayahById(wilayah_id, wilayah);
    }

    @RequestMapping(path = "/wilayah/{wilayah_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteWilayahById(@PathVariable(value = "wilayah_id") Long wilayah_id){
        return wilayahService.deleteById(wilayah_id);
    }
}
