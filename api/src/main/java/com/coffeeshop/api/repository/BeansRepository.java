package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.BeansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BeansRepository extends JpaRepository<BeansEntity, Long> {

    @Query(value = """
            SELECT * FROM beans_ref
            """, nativeQuery = true)
    List<BeansEntity> getBeans();

}
