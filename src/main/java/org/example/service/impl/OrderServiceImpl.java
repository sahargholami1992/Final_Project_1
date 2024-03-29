package org.example.service.impl;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.SubService;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.example.service.dto.OrderDto;

import javax.persistence.NoResultException;
import java.time.LocalDate;

public class OrderServiceImpl extends BaseServiceImpl<Integer, Order, OrderRepository>
                                 implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }

    @Override
    public void registerOrder(OrderDto dto, Customer customer, SubService subService) {
        if (dto.getRecommendedPrice() > subService.getBasePrice() && dto.getDateDoOrder().isAfter(LocalDate.now())) {
            Order order = new Order();
            order.setCustomer(customer);
            order.setSubService(subService);
            order.setAddress(dto.getAddress());
            order.setRecommendedPrice(dto.getRecommendedPrice());
            order.setDescription(dto.getDescription());
            order.setDateDoOrder(dto.getDateDoOrder());
            order.setStatusOrder(dto.getStatusOrder());
            repository.saveOrUpdate(order);
        }else throw new NoResultException(" time or price in not valid");

    }
}
