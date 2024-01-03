package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    @Query(value = """
            select * from shop_ref
            """, nativeQuery = true)
    List<ShopEntity> getShops();

}
