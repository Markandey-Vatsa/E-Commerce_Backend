package com.e_commerce.ecommerce_backend.Entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Localuser user;

    @Column(nullable = false, length = 512)
    private String AddressLine1;

    @Column(length = 512)
    private String AddressLine2;

    @Column(nullable = false, length = 512)
    private String City;

    @Column(nullable = false,length = 100)
    private String country;

    @Column(nullable = false)
    private Long postalCode;

    @Column(nullable = false)
    private String ActiveAddress;

}
