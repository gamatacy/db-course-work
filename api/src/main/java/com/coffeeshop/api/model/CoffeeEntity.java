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
@Table(name = "coffee_ref")
public class CoffeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coffee_ref_id_seq")
    @SequenceGenerator(name = "coffee_ref_id_seq", sequenceName = "coffee_ref_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "beans_id")
    private BeansEntity beans;

    @ManyToOne
    @JoinColumn(name = "milk_id")
    private MilkEntity milk;

    @ManyToOne
    @JoinColumn(name = "syrup_id")
    private SyrupEntity syrup;

    @ManyToOne
    @JoinColumn(name = "coffee_size_id")
    private CoffeeSizeEntity coffeeSizeEntity;

}
