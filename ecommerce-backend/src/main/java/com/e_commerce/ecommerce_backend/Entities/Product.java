package com.e_commerce.ecommerce_backend.Entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 100)
    private String Name;


    @Column(nullable = false)
    private String Short_desc;

    @Column(nullable = false)
    private String long_desc;

    @Column(nullable = false)
    private Double Price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;


}
