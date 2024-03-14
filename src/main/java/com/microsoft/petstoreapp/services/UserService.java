package com.microsoft.petstoreapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import com.microsoft.petstoreapp.entities.User;
import com.microsoft.petstoreapp.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private Map<Integer, User> userMap = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();

    //Create
    public User addUser(User newUser){
        return this.repository.save(newUser);
    }

    //Read All
    public Iterable<User> getAll(){
        return this.repository.findAll();
    }

    //Read One
    public User getByID(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    //Update
    public User updateUser(Integer id, User updatedUser){
        updatedUser.setId(id);
        return this.repository.save(updatedUser);
    }

    //Delete
    public void deleteUser(Integer id){
        this.repository.deleteById(id);
    }

    
}