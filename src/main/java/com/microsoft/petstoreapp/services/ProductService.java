package com.microsoft.petstoreapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsoft.petstoreapp.entities.Product;
import com.microsoft.petstoreapp.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    // private Map<Integer, Product> productMap = new HashMap<>();
    // private AtomicInteger atomic = new AtomicInteger();

    //Create
    public Product addProduct(Product newProduct){
       return this.repository.save(newProduct);
    }

    //Read all
    public Iterable<Product> getAll(){
        return this.repository.findAll();
    }

    //Read Single
    public Product getByID(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    //Delete
    public void deleteProduct(Integer id){
        this.repository.deleteById(id);
    }

  //Update
  public Product updateProduct(Integer id, Product updatedProduct){
    updatedProduct.setId(id);
    return this.repository.save(updatedProduct);
    }
    





}
