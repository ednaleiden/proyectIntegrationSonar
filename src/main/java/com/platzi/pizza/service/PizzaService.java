package com.platzi.pizza.service;

import com.platzi.pizza.persitence.entity.PizzaEntity;
import com.platzi.pizza.persitence.repository.PizzaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRespository pizzaRespository1;

    @Autowired
    public PizzaService(PizzaRespository pizzaRespository1) {
        this.pizzaRespository1 = pizzaRespository1;

    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRespository1.findAll();
    }
    public List<PizzaEntity> getAvailable() {
        return this.pizzaRespository1.findAllByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getByName(String name) {
        return this.pizzaRespository1.findAllByAvailableTrueAndNameIgnoreCase(name);
    }
    public PizzaEntity get(int id){
        return this.pizzaRespository1.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRespository1.save(pizza);
    }

    public void delete(int idPizza){
        this.pizzaRespository1.deleteById(idPizza);
    }


    public boolean exists(int idPizza) {
        return this.pizzaRespository1.existsById(idPizza);
    }


}
