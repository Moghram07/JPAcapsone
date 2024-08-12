package com.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(columnDefinition = "varchar(15) not null unique")
    @NotEmpty(message = "userName can not be empty")
    private String userName;

    @Column(columnDefinition = "varchar(15) not null unique")
    @NotEmpty(message = "password can not be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!@#$%^&*]).{8,}$", message = "password must be 8 characters minimum and must have one of each of the following [a-z, A-Z, 0-9, !@#$%^&*]")
    private String password;

    @Column(columnDefinition = "varchar(30) not null unique")
    @NotEmpty(message = "email can not be empty")
    @Email
    private String email;

    @Column(columnDefinition = "varchar(10) not null")
    @NotEmpty(message = "role can not be empty")
    @Pattern(regexp = "admin|customer", message = "role must be admin or customer")
    private String role;

    @Column(columnDefinition = "double not null")
    @NotNull(message = "balance can not be empty")
    @Positive(message = "balance must be a positive number")
    private double balance;

    @ManyToMany
    @JoinTable(
            name = "user_shopping_cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> shoppingCart = new ArrayList<>();

}
