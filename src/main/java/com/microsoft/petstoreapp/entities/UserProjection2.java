package com.microsoft.petstoreapp.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "userprojection2", types = {User.class})
public interface UserProjection2 {
    Integer getId();
    String getFirstName();
    String getLastName();
    
}
