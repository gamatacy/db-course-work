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
@Table(name = "cat_jn")
public class CatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_jn_id_seq")
    @SequenceGenerator(name = "cat_jn_id_seq", sequenceName = "cat_jn_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @Column(name = "age")
    private Long age;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "photo_url")
    private String photoUrl;

}
