package com.jose.pizza.service;

import com.jose.pizza.persistence.PizzaRespository;
import com.jose.pizza.persistence.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PizzaService {

    private final PizzaRespository pizzaRespository;

    @Autowired
    public PizzaService(PizzaRespository pizzaRespository) {
        this.pizzaRespository = pizzaRespository;
    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRespository.findAll();
    }

    public PizzaEntity getById(UUID idPizza){
        return this.pizzaRespository.findById(idPizza).orElse(null);
    }


}
