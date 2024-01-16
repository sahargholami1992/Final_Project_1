package org.example.service.impl;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.Service;
import org.example.repository.ServiceRepository;
import org.example.service.ServiceService;

public class ServiceServiceImpl extends BaseServiceImpl<Integer, Service, ServiceRepository>
                                 implements ServiceService {
    public ServiceServiceImpl(ServiceRepository repository) {
        super(repository);
    }

    @Override
    public boolean existByServiceName(String serviceName) {
        return repository.existByServiceName(serviceName);
    }

    @Override
    public Service findByServiceName(String serviceName) {
        return repository.findByServiceName(serviceName).orElseThrow(() -> new NullPointerException("userName or password is wrong"));
    }
}
