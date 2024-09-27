package com.jose.pizza.service;

import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import com.jose.pizza.persistence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PizzaOrderService {
    private final PizzaOrderRepository pizzaOrderRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

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

    public List<PizzaOrderEntity> getTodayPizzaOrders() {
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return this.pizzaOrderRepository.findAllByDateAfter(today);
    }

    public List<PizzaOrderEntity> getOutsidePizzaOrders() {
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.pizzaOrderRepository.findAllByMethodIn(methods);
    }

}
