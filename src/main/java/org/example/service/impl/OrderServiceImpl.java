package org.example.service.impl;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Order;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;

public class OrderServiceImpl extends BaseServiceImpl<Integer, Order, OrderRepository>
                                 implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
