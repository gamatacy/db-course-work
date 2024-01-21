package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Long> {

    @Query(value = """
            SELECT create_or_get_coffee(:beans_id, :milk_id, :syrup_id, :size_id)
            """, nativeQuery = true)
    void createCoffee(@Param("milk_id") Integer milk, @Param("beans_id") Integer beans, @Param("syrup_id") Integer syrup, @Param("size_id") Integer size);

    @Query(value = """
            SELECT * from coffee_ref where beans_id = :beans_id and milk_id = :milk_id and syrup_id = :syrup_id and coffee_size_id = :size_id
            """, nativeQuery = true)
    List<CoffeeEntity> getCoffee(@Param("milk_id") Integer milk, @Param("beans_id") Integer beans, @Param("syrup_id") Integer syrup, @Param("size_id") Integer size);

    @Query(value = """
            SELECT * FROM coffee_ref JOIN s333580.coffee_sale_ref csr on coffee_ref.id = csr.coffee_id
            """, nativeQuery = true)
    List<CoffeeEntity> getCoffeeWithSale();


}
