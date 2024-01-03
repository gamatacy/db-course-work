package com.coffeeshop.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "client_jn")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_jn_id_seq")
    @SequenceGenerator(name = "client_jn_id_seq", sequenceName = "client_jn_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String price;

    @Column(name = "registration_date")
    private String registrationDate;

    @ManyToOne
    @JoinColumn(name = "favourite_shop")
    private ShopEntity favouriteShop;

    @ManyToOne
    @JoinColumn(name = "favourite_coffee")
    private CoffeeEntity favouriteCoffee;

}
