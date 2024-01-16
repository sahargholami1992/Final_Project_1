package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.service.dto.CustomerRegisterDto;
import org.example.service.user.UserService;

import java.util.Collection;

public interface CustomerService extends UserService<Customer> {
    void registerCustomer(CustomerRegisterDto dto);
    Collection<Service> showAllService();
    Collection<SubService> showAllSubServiceByService(Service service);
}
