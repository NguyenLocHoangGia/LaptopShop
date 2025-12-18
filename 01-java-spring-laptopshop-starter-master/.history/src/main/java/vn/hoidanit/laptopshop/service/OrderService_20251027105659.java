package vn.Laptopshop.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.Laptopshop.laptopshop.domain.Order;
import vn.Laptopshop.laptopshop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
}
