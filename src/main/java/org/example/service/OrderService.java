package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.SubService;
import org.example.service.dto.OrderDto;

public interface OrderService extends BaseService<Integer, Order> {
    void registerOrder(OrderDto dto, Customer customer, SubService subService);
}
