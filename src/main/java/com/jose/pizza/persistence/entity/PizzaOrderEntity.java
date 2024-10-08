package com.jose.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pizza_order", schema = "main")
@Getter
@Setter
@NoArgsConstructor
public class PizzaOrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_order", nullable = false)
    private UUID idOrder;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "method", nullable = false, length = 1)
    private String method;

    @Column(name = "additional_notes")
    private String additionalNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", nullable = false)
    @JsonIgnore
    private CustomerEntity customer;

    @OneToMany(mappedBy = "pizzaOrder", fetch = FetchType.EAGER)
    @OrderBy("price ASC")
    private List<OrderItemEntity> orderItems;

}
