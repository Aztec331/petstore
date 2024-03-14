package com.microsoft.petstoreapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.microsoft.petstoreapp.entities.Product;


public interface ProductRepository 
    extends JpaRepository<Product, Integer>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    //where name = name
    Product findByName(String name);

    //where price > value
    //http://localhost:8080/products/search/findByPriceGreaterThan?value=300
    List<Product> findByPriceGreaterThan(double value);
    //where price < value
    List<Product> findByPriceLessThan(double value);
    //where price between low and high
    //http://localhost:8080/products/search/findByPriceBetween?low=100&high=300
    List<Product> findByPriceBetween(double low, double high);

}

    
    

