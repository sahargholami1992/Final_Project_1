package org.example.service.impl;

import org.example.entity.Customer;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.example.service.ServiceService;
import org.example.service.SubServiceService;
import org.example.service.dto.CustomerRegisterDto;
import org.example.service.user.UserServiceImpl;

import java.util.Collection;

public class CustomerServiceImpl extends UserServiceImpl<Customer, CustomerRepository>
                              implements CustomerService {
    protected final SubServiceService subServiceService;
    protected final ServiceService serviceService;
    public CustomerServiceImpl(CustomerRepository repository,SubServiceService subServiceService,ServiceService serviceService) {
        super(repository);
        this.subServiceService  =subServiceService;
        this.serviceService=serviceService;
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

    @Override
    public Collection<Service> showAllService() {
        return serviceService.loadAll();
    }

    @Override
    public Collection<SubService> showAllSubServiceByService(Service service) {
        return subServiceService.findByService(service);
    }
}
