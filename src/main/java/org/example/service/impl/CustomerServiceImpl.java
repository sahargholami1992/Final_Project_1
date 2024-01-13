package org.example.service.impl;

import org.example.entity.Customer;
import org.example.entity.Expert;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.example.service.dto.CustomerRegisterDto;
import org.example.service.user.UserServiceImpl;

public class CustomerServiceImpl extends UserServiceImpl<Customer, CustomerRepository>
                              implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public void registerCustomer(CustomerRegisterDto dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setDateRegister(dto.getDateRegister());
        customer.setRoll(dto.getRoll());
        customer.setPermission(dto.getPermission());
        repository.saveOrUpdate(customer);
    }
}
