package com.primeton.springproject.service;

import com.primeton.springproject.entity.Product;
import com.primeton.springproject.repository.ProductRepository;
import com.primeton.springproject.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
            List<Product> productList = productRepository.findAll();
            return productList;
    }

    public  Product findById(int id){
        try {
            Product product = productRepository.getById(id);
            return product;
        }
        catch(EntityNotFoundException e){
            return null;
        }
    }

    public Product create(Product product){
        productRepository.save(product);
        return product;
    }

    public Product update(Product product){
        if (product != null && product.getId() != null){
            Product newProduct = productRepository.getById(product.getId());
            JpaUtil.copyNotNullProperties(product, newProduct);
            return productRepository.save(newProduct);
        }
        return null;
    }

    public String deleteById(int id) {
        productRepository.deleteById(id);
        return "Success";
    }
 }
