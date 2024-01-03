package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.AllergenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AllergenRepository extends JpaRepository<AllergenEntity, Long> {

    @Query(value = """
            select * from milk_allergen_ref where milk_id = :p_milk_id
            """, nativeQuery = true)
    List<AllergenEntity> getMilkAllergens(@Param("p_milk_id") Integer milkId);

    @Query(value = """
            select * from syrup_allergen_ref where syrup_id = :p_syrup_id
            """, nativeQuery = true)
    List<AllergenEntity> getSyrupAllergens(@Param("p_syrup_id") Integer syrupId);

    @Query(value = """
            select * from filling_allergen_ref where filling_id = :p_filling_id
            """, nativeQuery = true)
    List<AllergenEntity> getFillingAllergens(@Param("p_filling_id") Integer fillingId);

}
