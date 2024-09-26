package com.jose.pizza.web.controller;

import com.jose.pizza.persistence.entity.PizzaEntity;
import com.jose.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable UUID idPizza) {
        return ResponseEntity.ok(this.pizzaService.getById(idPizza));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> AddPizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() == null || !this.pizzaService.existsPizza(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> UpdatePizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() != null || this.pizzaService.existsPizza(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }


}
