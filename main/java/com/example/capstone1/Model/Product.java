package com.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "product name can not be empty")
    private String productName;

    @Column(columnDefinition = "double not null")
    @NotNull(message = "price can not be null")
    @Positive(message = "price must be a positive number")
    private double price;

    @Column(columnDefinition = "varchar(30) not null")
    @NotEmpty(message = "description can not be null")
    private String description;

    @Column(columnDefinition = "varchar(15) not null")
    @NotEmpty(message = "product category can not be empty")
    private String productCategory;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "categoryId can not be empty")
    private int categoryId;

    @AssertFalse
    private boolean addToShoppingCart;
}
