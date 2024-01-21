package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatRepository extends JpaRepository<CatEntity, Long> {

    @Query(value = """
            select * from cat_jn 
            where shop_id = :p_shop_id
            """, nativeQuery = true)
    List<CatEntity> getCatsByShopId(@Param("p_shop_id") Integer shopId);

}
