package com.example.capstone1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MerchantStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(15) not null unique")
    @NotNull(message = "product id can not be null")
    private int productId;

    @Column(columnDefinition = "varchar(15) not null unique")
    @NotNull(message = "merchant id can not be null")
    private int merchantId;

    @Column(columnDefinition = "int not null ")
    @NotNull(message = "quantity can not be null")
    private int quantity;
}
