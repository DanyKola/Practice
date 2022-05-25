package com.example.demo.controller;

import com.example.demo.db.service.api.ProductService;
import com.example.demo.db.service.api.request.UpdateProductRequest;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Product> productList = productService.getProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable ("id")int id){
        Product product = productService.get(id);
        if (product!=null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Product product){
        Integer id = productService.add(product);
        if (id!=null){
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable ("id") int id){
        if (productService.get(id)!=null){
            productService.delete(id);
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity
                    .status(HttpStatus.PRECONDITION_FAILED)
                    .body("Produkt s tímto ID "+id+ " nenalezen, proto nejde smazat");
        }
    }
    @PatchMapping("{id}")
    public ResponseEntity updateProduct(@PathVariable ("id") int id, @RequestBody UpdateProductRequest updateProductRequest){
        if (productService.get(id) != null){
            productService.update(id, updateProductRequest);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.PRECONDITION_FAILED)
                    .body("Produkt s ID " +id +" neexistuje, proto nelze updatovat");
        }

    }
}
