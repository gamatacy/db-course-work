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
@Table(name = "review_jn")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_jn_id_seq")
    @SequenceGenerator(name = "review_jn_id_seq", sequenceName = "review_jn_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "review_text")
    private String text;

    @Column(name = "date")
    private String date;

}
