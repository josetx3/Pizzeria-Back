package com.jose.pizza.service;

import com.jose.pizza.persistence.PizzaRepository;
import com.jose.pizza.persistence.entity.PizzaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRespository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRespository) {
        this.pizzaRespository = pizzaRespository;
    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRespository.findAll();
    }

    public PizzaEntity getById(UUID idPizza) {
        return this.pizzaRespository.findById(idPizza).orElse(null);
    }

    public PizzaEntity savePizza(PizzaEntity pizza) {
        return this.pizzaRespository.save(pizza);
    }

    public void deletePizza(UUID idPizza){
        this.pizzaRespository.deleteById(idPizza);
    }

    public boolean existsPizza(UUID idPizza) {
        return this.pizzaRespository.existsById(idPizza);
    }

}
