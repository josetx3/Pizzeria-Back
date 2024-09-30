package com.jose.pizza.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdatePizzaDto {
    private UUID pizzaId;
    private String name;
    private String description;
    private Double price;
    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean available;
}
