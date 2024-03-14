package com.microsoft.petstoreapp.entities;

import java.time.Instant;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
// @Table(name= "tblProduct")
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    //we are telling the database to auto generate
    //the unique id values
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Length(min = 3, max = 20, message = "product name should have 3-20 characters")
    private String name;
    @NotNull
    @Min(value = 0)
    @Max(value= 4000)
    private Double price;
    private String description;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    //One product belongs to one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
}
