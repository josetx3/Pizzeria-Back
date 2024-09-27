package com.jose.pizza.persistence.repository;

import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, UUID> {
    List<PizzaOrderEntity> findAllByDateAfter(LocalDateTime date);

    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);
}
