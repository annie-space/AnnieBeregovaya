package com.anna.tgBot.model;

import jakarta.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ClientOrder clientOrder;

    @ManyToOne(optional = false)
    private Product product;

    @Column(nullable = false)
    private Integer countProduct;

    // геттеры и сеттеры
}
