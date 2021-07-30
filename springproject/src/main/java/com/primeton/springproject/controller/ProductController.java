package com.primeton.springproject.controller;

import com.primeton.springproject.entity.Product;
import com.primeton.springproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping(value = "/findById")
    public Object findById(@RequestParam int id) {
        return productService.findById(id);
    }

    @PostMapping(value = "/create")
    public Object create(Product product){
        return productService.create(product);
    }

    @PutMapping(value = "/update")
    public Object update(Product product){
        return productService.update(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@RequestParam int id){
        return productService.deleteById(id);
    }

}
