package com.jose.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "pizza", schema = "main")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class PizzaEntity extends AuditableEntity {

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

    @OneToOne(mappedBy = "pizza", fetch = FetchType.EAGER)
    @JsonIgnore     //Si tiene esto no viajaran hasta la consulta y no se mostraran
    private OrderItemEntity orderItems;

    public void updatePizza(String name, String description, Double price, Boolean vegetarian, Boolean vegan, Boolean available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.available = available;
    }
}
