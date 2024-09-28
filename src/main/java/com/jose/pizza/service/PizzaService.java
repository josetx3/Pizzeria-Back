package com.jose.pizza.service;

import com.jose.pizza.persistence.repository.PizzaRepository;
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

    public List<PizzaEntity> getAllAvailable() {
        System.out.println("================================================");
        System.out.println(this.pizzaRespository.countByVeganTrue());
        System.out.println("================================================");
        return this.pizzaRespository.findAllByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getAllAvailableByName(String name) {
        return this.pizzaRespository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("La pizza no existe"));
    }

    public List<PizzaEntity> getDescriptionPizza(String ingredient) {
        return this.pizzaRespository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getNotDescriptionPizza(String ingredient) {
        return this.pizzaRespository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapestPizzas(double price) {
        return this.pizzaRespository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity getById(UUID idPizza) {
        return this.pizzaRespository.findById(idPizza).orElse(null);
    }

    public PizzaEntity savePizza(PizzaEntity pizza) {
        return this.pizzaRespository.save(pizza);
    }

    public void deletePizza(UUID idPizza) {
        this.pizzaRespository.deleteById(idPizza);
    }

    public boolean existsPizza(UUID idPizza) {
        return this.pizzaRespository.existsById(idPizza);
    }

}
