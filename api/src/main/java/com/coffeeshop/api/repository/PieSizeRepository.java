package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.PieSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PieSizeRepository extends JpaRepository<PieSizeEntity, Long> {

    @Query(value = """
            SELECT * FROM pie_size_ref
            """, nativeQuery = true)
    List<PieSizeEntity> getPieSizes();

}
