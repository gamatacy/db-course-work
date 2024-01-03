package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query(value = """
            SELECT * FROM client_jn WHERE name = :name and password = :password
            """, nativeQuery = true)
    ClientEntity checkPassword(@Param("name") String name, @Param("password") String password);

    @Query(value = """
            INSERT INTO client_jn (name,password) values (:name, :password) RETURNING *
            """, nativeQuery = true)
    ClientEntity addClient(@Param("name") String name, @Param("password") String password);

    @Query(value = """
            SELECT * FROM client_jn WHERE name = :name
            """, nativeQuery = true)
    ClientEntity getClientByName(@Param("name") String name);

    @Query(value = """
            SELECT * FROM client_jn WHERE id = :id
            """, nativeQuery = true)
    ClientEntity getClientById(@Param("id") Long id);


    @Query(value = """
            SELECT loyalty_program_jn.bonus_points FROM loyalty_program_jn JOIN client_jn ON loyalty_program_jn.client_id = client_jn.id
            where client_jn.id = :id
            """, nativeQuery = true)
    Long getBonusPoints(@Param("id") Long id);

    @Query(value = """
            SELECT decrease_bonus_points(:id, :amount)
            """, nativeQuery = true)
    void spendBonusPoints(@Param("id") Integer id, @Param("amount") Integer amount);

    @Query(value = """
            SELECT add_to_favorite_coffee(:id, :beans_id, :milk_id, :syrup_id, :size_id)
            """, nativeQuery = true)
    void saveFavouriteCoffee(@Param("id") Integer id, @Param("milk_id") Integer milk, @Param("beans_id") Integer beans, @Param("syrup_id") Integer syrup, @Param("size_id") Integer size);

}
