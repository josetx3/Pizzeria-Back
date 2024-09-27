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

    //    LISTAR TODAS LAS PIZZAS
    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    //    Listar pizza por ID
    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable UUID idPizza) {
        return ResponseEntity.ok(this.pizzaService.getById(idPizza));
    }

    //    Listar pizzas disponibles
    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> getAllAvailable() {
        return ResponseEntity.ok(this.pizzaService.getAllAvailable());
    }

    //Buscar pizza por nombre
    @GetMapping("/available/{name}")
    public ResponseEntity<PizzaEntity> getAllAvailableByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getAllAvailableByName(name));
    }

    //Buscar pizza por descripcion | por ingrediente
    @GetMapping("ingredients/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getDescriptionPizza(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getDescriptionPizza(ingredient));
    }

    //Buscar pizza que no tenga el ingrediente
    @GetMapping("not-ingredients/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getNotDescriptionPizza(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getNotDescriptionPizza(ingredient));
    }

    // Registrar una pizza
    @PostMapping
    public ResponseEntity<PizzaEntity> AddPizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() == null || !this.pizzaService.existsPizza(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    //    Editar una pizza por id
    @PutMapping
    public ResponseEntity<PizzaEntity> UpdatePizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() != null || this.pizzaService.existsPizza(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    //    Eliminar una pizza
    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> deletePizza(@PathVariable UUID idPizza) {
        if (this.pizzaService.existsPizza(idPizza)) {
            this.pizzaService.deletePizza(idPizza);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
