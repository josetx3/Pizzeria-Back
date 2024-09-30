package com.jose.pizza.persistence.projection;

import java.time.LocalDateTime;
import java.util.UUID;

public interface PizzaOrderSummary {
    UUID getIdOrder();
    String getCustomerName();
    LocalDateTime getPizzaOrderDate();
    Double getPizzaOrderTotal();
    String getPizzaNames();
}
