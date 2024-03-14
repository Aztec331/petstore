package com.microsoft.petstoreapp.entities;

import java.time.Instant;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.microsoft.petstoreapp.validators.Phone;
import com.microsoft.petstoreapp.validators.VerifyPassword;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
// @VerifyPassword(field1 = "password", field2 = "confirmPassword")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull(message = "first name cannot be null")
    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotNull(message = "last name cannot be null")
    @Length(min = 3, max= 10, message = "last name should have 3-10 characters")
    private String lastName;

    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    @NotNull(message = "phone cannot be null")
    @Phone
    private String phone;

    private String password;

    @Transient
    //@Transient will make sure that the column
    //of this field is not created in the table
    private String confirmPassword;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    //one user can have only one address
    //here in the user table created for this User entity
    //we want to add foreign key column to refer the id 
    //of the address, use @JoinColumn annotation
    @OneToOne
    @JoinColumn(name = "addr_id")
    private Address addr;

}
