package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.BeansEntity;
import com.coffeeshop.api.model.CoffeeEntity;
import com.coffeeshop.api.model.SyrupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SyrupRepository extends JpaRepository<SyrupRepository, Long> {

    @Query(value = """
            SELECT * FROM syrup_ref
            """, nativeQuery = true)
    List<SyrupEntity> getSyrups();

}
