package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.BeansEntity;
import com.coffeeshop.api.model.MilkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MilkRepository extends JpaRepository<MilkEntity, Long> {

    @Query(value = """
            SELECT * FROM milk_ref
            """, nativeQuery = true)
    List<MilkEntity> getMilks();

}
