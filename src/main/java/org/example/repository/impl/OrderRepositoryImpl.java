package org.example.repository.impl;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Order;
import org.example.repository.OrderRepository;

import javax.persistence.EntityManager;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Integer, Order>
                               implements OrderRepository {
    public OrderRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Order> getEntityClass() {
        return Order.class;
    }
}
