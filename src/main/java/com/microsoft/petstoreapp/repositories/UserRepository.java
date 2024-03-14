package com.microsoft.petstoreapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.microsoft.petstoreapp.entities.User;
import com.microsoft.petstoreapp.entities.UserProjection1;

//excerptProjection is used to set the default projection
//when we extract all the user records

@RepositoryRestResource(excerptProjection = UserProjection1.class)
public interface UserRepository 
    extends CrudRepository<User, Integer>{
   //query methods -> methods in the repository,
    //created as per the structure of the entity
    //and these method calls will be converted into
    //SQL query by the hibernate. There are many
    //pre-defined query methods in the repository
    //but we can create more as per the required
    
    //custom query methods -> query methods created
    //by the developer for handling the request for
    //the particular case
    List<User> findByFirstName(String name);
    
}
