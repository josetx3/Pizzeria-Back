package com.jose.pizza.persistence;

import com.jose.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, UUID> {

}
