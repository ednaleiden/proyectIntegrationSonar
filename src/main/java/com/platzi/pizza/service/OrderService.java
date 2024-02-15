package com.platzi.pizza.service;

import com.platzi.pizza.persitence.entity.OrderEntity;
import com.platzi.pizza.persitence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private  final OrderRepository orderrepository;

    @Autowired
    public OrderService(OrderRepository orderrepository) {
        this.orderrepository = orderrepository;
    }

    public List<OrderEntity> getAll() {
        List<OrderEntity> orders = this.orderrepository.findAll();
        orders.forEach(o -> System.out.println(o.getCustomer().getName()));
        return this.orderrepository.findAll();
    }

    public List<OrderEntity> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return this.orderrepository.findAllByDateAfter(today);
    }
}
