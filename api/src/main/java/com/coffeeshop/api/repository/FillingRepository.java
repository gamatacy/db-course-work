package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.FillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FillingRepository extends JpaRepository<FillingEntity, Long> {

    @Query(value = """
            SELECT * FROM pie_filling_ref
            """, nativeQuery = true)
    List<FillingEntity> getFillings();

}
