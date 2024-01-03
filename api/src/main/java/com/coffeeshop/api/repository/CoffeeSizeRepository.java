package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.CoffeeSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoffeeSizeRepository extends JpaRepository<CoffeeSizeEntity, Long> {

    @Query(value = """
            SELECT * FROM coffee_size_ref
            """, nativeQuery = true)
    List<CoffeeSizeEntity> getCoffeeSizes();

}
