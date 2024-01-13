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
}
