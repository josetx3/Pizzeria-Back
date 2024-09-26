package com.jose.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "order_item", schema = "main")
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_item", nullable = false)
    private UUID idItem;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToOne
    @JoinColumn(name = "id_pizza", nullable = false, referencedColumnName = "id_pizza")
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false, referencedColumnName = "id_order")
    private PizzaOrderEntity pizzaOrder;


}
