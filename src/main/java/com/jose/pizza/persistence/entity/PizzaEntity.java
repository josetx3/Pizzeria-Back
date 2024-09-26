package com.jose.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pizza", schema = "main")
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_pizza", nullable = false)
    private UUID idPizza;

    @Column(name = "name", nullable = false, length = 30, unique = true)
    private String name;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "vegetarian")
    private Boolean vegetarian;

    @Column(name = "vegan")
    private Boolean vegan;

    @Column(name = "available", nullable = false)
    private Boolean available;

    @OneToMany(mappedBy = "pizza", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrderItemEntity> orderItems;

}
