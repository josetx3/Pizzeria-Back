package com.jose.pizza.persistence.repository;

import com.jose.pizza.persistence.entity.PizzaOrderEntity;
import com.jose.pizza.persistence.projection.PizzaOrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrderEntity, UUID> {
    List<PizzaOrderEntity> findAllByDateAfter(LocalDateTime date);

    List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT * FROM main.pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<PizzaOrderEntity> findCustomerOrders(@Param("id") UUID idCustomer);

    @Query(value = " SELECT po.id_order AS idOrder, cu.name AS customerName, po.date AS pizzaOrderDate, po.total AS pizzaOrderTotal, STRING_AGG(pi.name, ', ') AS pizzaNames" +
            " FROM main.pizza_order po" +
            " INNER JOIN main.customer cu ON po.id_customer = cu.id_customer" +
            " INNER JOIN main.order_item oi ON po.id_order = oi.id_order" +
            " INNER JOIN main.pizza pi ON oi.id_pizza = pi.id_pizza " +
            " WHERE po.id_order = :orderId" +
            " GROUP BY  po.id_order, cu.name, po.date, po.total ", nativeQuery = true)
    PizzaOrderSummary findSummary(@Param("orderId") UUID orderId);

}
