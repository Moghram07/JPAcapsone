package com.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int merchantId;

    @Column(columnDefinition = "varchar(15) not null unique")
    @NotEmpty(message = "name can not be empty")
    private String merchantName;

    @Column(columnDefinition = "varchar(30) not null unique")
    @NotEmpty(message = "address can not be empty")
    private String address;

    @Column(columnDefinition = "varchar(10) not null unique")
    @NotEmpty(message = "phone can not be empty")
    @Pattern(regexp = "^05[\\d]{8}$", message = "phone has to start with 05 and 8 other numbers")
    private String phone;

    @Column(columnDefinition = "varchar(30) not null unique")
    @NotEmpty(message = "email can not be empty")
    @Email
    private String email;
}
