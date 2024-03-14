package com.microsoft.petstoreapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.microsoft.petstoreapp.entities.Address;

public interface AddressRepository 
    extends CrudRepository<Address, Integer> {
    
    
}
