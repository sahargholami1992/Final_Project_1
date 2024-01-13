package org.example.repository.impl;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.example.repository.user.UserRepositoryImpl;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends UserRepositoryImpl<Customer>
                               implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
