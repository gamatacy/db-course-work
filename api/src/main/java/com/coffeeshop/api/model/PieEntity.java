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
@Table(name = "pie_ref")
public class PieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pie_ref_id_seq")
    @SequenceGenerator(name = "pie_ref_id_seq", sequenceName = "pie_ref_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pie_filling_id")
    private FillingEntity filling;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private PieSizeEntity pieSize;
}
