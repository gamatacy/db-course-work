package com.coffeeshop.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "order_jn")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_jn_id_seq")
    @SequenceGenerator(name = "client_jn_id_seq", sequenceName = "client_jn_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "coffee_order_jn",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "coffee_id")
    )
    private List<CoffeeEntity> coffee;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "pie_order_jn",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pie_id")
    )
    private List<PieEntity> pies;

}
