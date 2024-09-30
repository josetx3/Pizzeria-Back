package com.jose.pizza.web.controller;

import com.jose.pizza.persistence.entity.PizzaEntity;
import com.jose.pizza.service.PizzaService;
import com.jose.pizza.service.dto.UpdatePizzaDto;
import com.jose.pizza.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int elements) {
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }

    //    Listar pizza por ID
    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable UUID idPizza) {
        return ResponseEntity.ok(this.pizzaService.getById(idPizza));
    }

    //    Listar pizzas disponibles
    @GetMapping("/available")
    public ResponseEntity<Page<PizzaEntity>> getAllAvailable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int elements,
            @RequestParam(defaultValue = "price") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {
        return ResponseEntity.ok(this.pizzaService.getAllAvailable(page, elements, sortBy, sortDirection));
    }

    //Buscar pizza por nombre
    @GetMapping("/available/{name}")
    public ResponseEntity<PizzaEntity> getAllAvailableByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getAllAvailableByName(name));
    }

    //Buscar pizza por descripcion | por ingrediente
    @GetMapping("/ingredients/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getDescriptionPizza(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getDescriptionPizza(ingredient));
    }

    //Buscar pizza que no tenga el ingrediente
    @GetMapping("/not-ingredients/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getNotDescriptionPizza(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getNotDescriptionPizza(ingredient));
    }

    //Me trae las 3 pizzas mas baratas desde el precio que yo le envie
    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapestPizzas(@PathVariable double price) {
        return ResponseEntity.ok(this.pizzaService.getCheapestPizzas(price));
    }

    // Registrar una pizza
    @PostMapping
    public ResponseEntity<PizzaEntity> AddPizza(@RequestBody PizzaEntity pizza) {
        if (pizza.getIdPizza() == null || !this.pizzaService.existsPizza(pizza.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.savePizza(pizza));
        }
        return ResponseEntity.badRequest().build();
//        return new ResponseEntity<>(pizzaService.savePizza(pizza), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{idPizza}")
    public ResponseEntity<Void> updatePizza(@PathVariable UUID idPizza, @RequestBody UpdatePizzaDto dto) {
        this.pizzaService.updatePizza(idPizza, dto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/price")
    public ResponseEntity<Void> updatePricePizza(@RequestBody UpdatePizzaPriceDto dto) {
        if (this.pizzaService.existsPizza(dto.getPizzaId())) {
            this.pizzaService.updatePricePizza(dto);
            return ResponseEntity.ok().build();
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
