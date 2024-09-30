package com.jose.pizza.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdatePizzaPriceDto {
    private UUID pizzaId;
    private double newPrice;
}
