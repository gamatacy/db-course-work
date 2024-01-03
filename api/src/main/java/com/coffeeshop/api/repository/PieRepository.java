package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.PieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PieRepository extends JpaRepository<PieEntity, Long> {

    @Query(value = """
            SELECT create_or_get_pie(:filling_id, :size_id)
            """, nativeQuery = true)
    PieEntity createPie(@Param("filling_id") Integer filling, @Param("size_id") Integer size);

    @Query(value = """
            SELECT * FROM pie_ref join s333580.pie_sale_ref psr on pie_ref.id = psr.pie_id
            """, nativeQuery = true)
    List<PieEntity> getPiesWithSale();

}
