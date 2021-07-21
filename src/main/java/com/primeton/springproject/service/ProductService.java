package com.primeton.springproject.service;

import com.primeton.springproject.entity.Product;
import com.primeton.springproject.repository.ProductRepository;
import com.primeton.springproject.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
            return productRepository.findAll();
    }

    public Object findById(int id) {
        if (productRepository.existsById(id)) {
            return productRepository.getById(id);
        }
        return "id does not exist";
    }


    public Object create(Product product){
        if(productRepository.existsById(product.getId())){
            return "id already exists";
        }
        productRepository.save(product);
        return product;
    }

    public Object update(Product product){
        if (productRepository.existsById(product.getId())){
            Product newProduct = productRepository.getById(product.getId());
            JpaUtil.copyNotNullProperties(product, newProduct);
            return productRepository.save(newProduct);
        }
        return "id does not exist";
    }

    public String deleteById(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "success";
        }
        return "id does not exist";
    }

 }
