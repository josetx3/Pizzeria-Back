package com.jose.pizza.persistence.repository;

import com.jose.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.UUID;

public interface PizzaPagSortRepository  extends ListPagingAndSortingRepository<PizzaEntity, UUID> {
    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
}
