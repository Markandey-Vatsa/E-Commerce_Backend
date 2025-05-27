package com.e_commerce.ecommerce_backend.Entities;


import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Web_Orders")
public class WebOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Localuser user;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Address address;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product prod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private ArrayList<WebOrderQuantities> quantities = new ArrayList<>();


}
