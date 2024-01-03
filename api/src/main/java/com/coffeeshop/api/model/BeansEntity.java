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
@Table(name = "beans_ref")
public class BeansEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beans_ref_id_seq")
    @SequenceGenerator(name = "beans_ref_id_seq", sequenceName = "beans_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "sort", nullable = false)
    private String sort;

    @Column(name = "price", nullable = false)
    private Float price;

}
