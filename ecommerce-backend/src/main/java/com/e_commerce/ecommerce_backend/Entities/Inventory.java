package com.e_commerce.ecommerce_backend.Entities;


import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;

@Entity
@Table(name="Inventory")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private Product product;

    @Column
    private Integer inStockQuant;

}
