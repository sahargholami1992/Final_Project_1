package org.example.repository;


import org.example.entity.Customer;
import org.example.repository.user.UserRepository;

public interface CustomerRepository extends UserRepository<Customer> {
}
