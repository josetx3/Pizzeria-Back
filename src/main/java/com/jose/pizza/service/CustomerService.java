package com.jose.pizza.service;

import com.jose.pizza.persistence.entity.CustomerEntity;
import com.jose.pizza.persistence.repository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRespository customerRespository;

    @Autowired
    public CustomerService(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    public CustomerEntity findByPhone(String phone) {
        return this.customerRespository.findByPhoneNumber(phone);
    }
}
