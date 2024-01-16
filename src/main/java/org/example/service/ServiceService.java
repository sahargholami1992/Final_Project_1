package org.example.service;

import org.example.base.service.BaseService;
import org.example.entity.Service;

public interface ServiceService extends BaseService<Integer, Service> {
    boolean existByServiceName(String serviceName);

    Service findByServiceName(String serviceName);
}
