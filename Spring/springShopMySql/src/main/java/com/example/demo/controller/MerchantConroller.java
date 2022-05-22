package com.example.demo.controller;

import com.example.demo.db.service.api.MerchantService;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Merchant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantConroller {

    public MerchantConroller(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    private final MerchantService merchantService;

    @PostMapping
    public ResponseEntity add(@RequestBody Merchant merchant){
        Integer id = merchantService.addMerchant(merchant);
        if (id!=null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping
    public ResponseEntity getAll(){
        List<Merchant> merchantList =merchantService.getMerchants();
        return new ResponseEntity<>(merchantList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Merchant merchant = merchantService.getM(id);
        if (merchant !=null){
            return new ResponseEntity<>(merchant, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
