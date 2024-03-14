package com.microsoft.petstoreapp.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


//Projection is the subset of the data from the entity
//rather than showing all the field in the result,
//we can restrict the field as per our selection
//whichever field we want in the result,
    //we will create its getter methods in this interface
@Projection(name = "userprojection1", types = {User.class})
public interface UserProjection1 {

    //whichever field we want in the result,
    //we will create its greater methods in this interface

    //closed projection => fields of the original class
    //are mapped as it is
    // String getFirstName();
    // String getLastName();
    String getEmail();
    String getPhone();

    //open projection => we can create new fields using
    //the values of the original fields
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
    
}
