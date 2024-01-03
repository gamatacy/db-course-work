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
@Table(name = "pie_filling_ref")
public class FillingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pie_filling_ref_id_seq")
    @SequenceGenerator(name = "pie_filling_ref_id_seq", sequenceName = "pie_filling_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String sort;

    @Column(name = "price", nullable = false)
    private Float price;

}
