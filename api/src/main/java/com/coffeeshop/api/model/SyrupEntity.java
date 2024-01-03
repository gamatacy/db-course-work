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
@Table(name = "syrup_ref")
public class SyrupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "syrup_ref_id_seq")
    @SequenceGenerator(name = "syrup_ref_id_seq", sequenceName = "syrup_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Float price;

}
