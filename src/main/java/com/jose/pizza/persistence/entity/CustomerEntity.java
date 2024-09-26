package com.jose.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer", schema = "main")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_customer", nullable = false)
    private UUID idCustomer;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private PizzaOrderEntity pizzaOrder;

}
