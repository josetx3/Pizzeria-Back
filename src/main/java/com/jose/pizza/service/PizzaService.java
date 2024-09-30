package com.jose.pizza.service;

import com.jose.pizza.persistence.repository.PizzaPagSortRepository;
import com.jose.pizza.persistence.repository.PizzaRepository;
import com.jose.pizza.persistence.entity.PizzaEntity;
import com.jose.pizza.service.dto.UpdatePizzaDto;
import com.jose.pizza.service.dto.UpdatePizzaPriceDto;
import com.jose.pizza.service.exception.EmailApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
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
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("La pizza no existe"));
    }

    public List<PizzaEntity> getDescriptionPizza(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getNotDescriptionPizza(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapestPizzas(double price) {
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity getById(UUID idPizza) {
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity savePizza(PizzaEntity pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public void deletePizza(UUID idPizza) {
        this.pizzaRepository.deleteById(idPizza);
    }

    public boolean existsPizza(UUID idPizza) {
        return this.pizzaRepository.existsById(idPizza);
    }

    @Transactional
    public void updatePizza(UUID idPizza, UpdatePizzaDto dto) {
        PizzaEntity pizzaEntity = pizzaRepository.findById(idPizza).orElseThrow(() -> new IllegalArgumentException("No existe la pizza"));
        pizzaEntity.updatePizza(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getVegetarian(), dto.getVegan(), dto.getAvailable());
        pizzaRepository.save(pizzaEntity);
    }

    @Transactional(noRollbackFor = EmailApiException.class, propagation = Propagation.REQUIRED)
    public void updatePricePizza(UpdatePizzaPriceDto dto) {
        this.pizzaRepository.updatePrice(dto);
        this.sendEmail();
    }

    private void sendEmail() {
        throw new EmailApiException();
    }


}
