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
@Table(name = "shop_ref")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_ref_id_seq")
    @SequenceGenerator(name = "shop_ref_id_seq", sequenceName = "shop_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "address")
    private String address;

}
