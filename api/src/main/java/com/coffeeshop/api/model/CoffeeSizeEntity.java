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
@Table(name = "coffee_size_ref")
public class CoffeeSizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coffee_size_ref_id_seq")
    @SequenceGenerator(name = "coffee_size_ref_id_seq", sequenceName = "coffee_size_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Float price;

}
