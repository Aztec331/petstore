package com.microsoft.petstoreapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.microsoft.petstoreapp.entities.Orders;


//we are creating the custom rest api url here
//because if we don't do it the default url for orders
//will be orderses which does not seems logical
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrdersRepository 
    extends JpaRepository<Orders, Integer>{


    
}
