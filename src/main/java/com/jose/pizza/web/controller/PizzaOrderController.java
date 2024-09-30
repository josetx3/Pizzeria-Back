package com.jose.pizza.web.controller;

import com.jose.pizza.persistence.entity.PizzaEntity;
import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import com.jose.pizza.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/pizza-orders")
public class PizzaOrderController {
    private final PizzaOrderService pizzaOrderService;

    @Autowired
    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaOrderEntity>> getAllPizzaOrder() {
        return ResponseEntity.ok(this.pizzaOrderService.getAllPizzaOrder());
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<PizzaOrderEntity> getPizzaOrderById(@PathVariable UUID idOrder) {
        return ResponseEntity.ok(this.pizzaOrderService.getPizzaOrderById(idOrder));
    }

    @GetMapping("/today")
    public ResponseEntity<List<PizzaOrderEntity>> getTodayPizzaOrders() {
        return ResponseEntity.ok(this.pizzaOrderService.getTodayPizzaOrders());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<PizzaOrderEntity>> getOutSidePizzaOrders() {
        return ResponseEntity.ok(this.pizzaOrderService.getOutsidePizzaOrders());
    }

    //Consultar cliente y mirar las ordenes
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<PizzaOrderEntity>> getCustomerOrders(@PathVariable UUID id) {
        return ResponseEntity.ok(this.pizzaOrderService.getCustomerOrders(id));
    }

}
