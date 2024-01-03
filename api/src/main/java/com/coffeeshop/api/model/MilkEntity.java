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
@Table(name = "milk_ref")
public class MilkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "milk_ref_id_seq")
    @SequenceGenerator(name = "milk_ref_id_seq", sequenceName = "milk_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Float price;

}
