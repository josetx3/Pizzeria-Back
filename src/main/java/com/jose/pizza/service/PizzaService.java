package com.jose.pizza.service;

import com.jose.pizza.persistence.repository.PizzaPagSortRepository;
import com.jose.pizza.persistence.repository.PizzaRepository;
import com.jose.pizza.persistence.entity.PizzaEntity;
import com.jose.pizza.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRespository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRespository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRespository = pizzaRespository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public Page<PizzaEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }

    public Page<PizzaEntity> getAllAvailable(int page, int elements, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);

    }

    public PizzaEntity getAllAvailableByName(String name) {
        return this.pizzaRespository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("La pizza no existe"));
    }

    public List<PizzaEntity> getDescriptionPizza(String ingredient) {
        return this.pizzaRespository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getNotDescriptionPizza(String ingredient) {
        return this.pizzaRespository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapestPizzas(double price) {
        return this.pizzaRespository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity getById(UUID idPizza) {
        return this.pizzaRespository.findById(idPizza).orElse(null);
    }

    public PizzaEntity savePizza(PizzaEntity pizza) {
        return this.pizzaRespository.save(pizza);
    }

    public void deletePizza(UUID idPizza) {
        this.pizzaRespository.deleteById(idPizza);
    }

    public boolean existsPizza(UUID idPizza) {
        return this.pizzaRespository.existsById(idPizza);
    }

    @Transactional
    public void updatePricePizza(UpdatePizzaPriceDto dto){
        this.pizzaRespository.updatePrice(dto);
    }



}
