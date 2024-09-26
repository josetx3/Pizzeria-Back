package com.jose.pizza.service;

import com.jose.pizza.persistence.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PizzaEntity> getAll(){
//        return this.jdbcTemplate.query("SELECT * FROM main.pizza", new BeanPropertyRowMapper<>(PizzaEntity.class));
        return this.jdbcTemplate.query("SELECT * FROM main.pizza WHERE available = false", new BeanPropertyRowMapper<>(PizzaEntity.class));
    }


}
