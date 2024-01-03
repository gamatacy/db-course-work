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
@Table(name = "status_ref")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_ref_id_seq")
    @SequenceGenerator(name = "status_ref_id_seq", sequenceName = "status_ref_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

}
