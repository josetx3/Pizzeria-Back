package com.jose.pizza.persistence.repository;

import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, UUID> {
}
