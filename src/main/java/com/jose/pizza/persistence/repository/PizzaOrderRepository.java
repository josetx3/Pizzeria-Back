package com.jose.pizza.persistence.repository;

import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, UUID> {
    List<PizzaOrderEntity> findAllByDateAfter(LocalDateTime date);

    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM main.pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<PizzaOrderEntity> findCustomerOrders(@Param("id") UUID idCustomer);
}
