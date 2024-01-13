package org.example.repository.impl;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Service;
import org.example.repository.ServiceRepository;

import javax.persistence.EntityManager;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Integer, Service>
                               implements ServiceRepository {
    public ServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Service> getEntityClass() {
        return Service.class;
    }
}
