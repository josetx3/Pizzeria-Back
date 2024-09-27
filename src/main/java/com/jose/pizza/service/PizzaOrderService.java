package com.jose.pizza.service;

import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import com.jose.pizza.persistence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PizzaOrderService {
    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public List<PizzaOrderEntity> getAllPizzaOrder() {
        List<PizzaOrderEntity> pizzaOrders = this.pizzaOrderRepository.findAll();
        pizzaOrders.forEach(o -> System.out.println(o.getCustomer().getName()));
        return pizzaOrders;
    }

    public PizzaOrderEntity getPizzaOrderById(UUID idOrder) {
        return this.pizzaOrderRepository.findById(idOrder).orElse(null);
    }
}
