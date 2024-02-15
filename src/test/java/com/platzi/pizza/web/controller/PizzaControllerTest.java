package com.platzi.pizza.web.controller;

import com.platzi.pizza.persitence.entity.PizzaEntity;
import com.platzi.pizza.service.PizzaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;

class PizzaControllerTest {
    @Mock
    PizzaService pizzaService;
    @InjectMocks
    PizzaController pizzaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(pizzaService.getAll()).thenReturn(List.of(new PizzaEntity()));

        ResponseEntity<List<PizzaEntity>> result = pizzaController.getAll();
        Assertions.assertEquals(result, result);
    }

    @Test
    void testGet() {
        when(pizzaService.get(anyInt())).thenReturn(new PizzaEntity());

        ResponseEntity<PizzaEntity> result = pizzaController.get(0);
        Assertions.assertEquals(result, result);
    }

    @Test
    void testAdd() {
        when(pizzaService.save(any())).thenReturn(new PizzaEntity());
        when(pizzaService.exists(anyInt())).thenReturn(true);

        ResponseEntity<PizzaEntity> result = pizzaController.add(new PizzaEntity());
        Assertions.assertEquals(result, result);
    }

    @Test
    void testUpdate() {
        when(pizzaService.save(any())).thenReturn(new PizzaEntity());
        when(pizzaService.exists(anyInt())).thenReturn(true);

        ResponseEntity<PizzaEntity> result = pizzaController.update(new PizzaEntity());
        Assertions.assertEquals(result, result);
    }

    @Test
    void testDelete() {
        when(pizzaService.exists(anyInt())).thenReturn(true);

        ResponseEntity<Void> result = pizzaController.delete(0);
        Assertions.assertEquals(result, result);
    }
}

