package org.example.repository.impl;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Service;
import org.example.repository.ServiceRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Integer, Service>
                               implements ServiceRepository {
    public ServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Service> getEntityClass() {
        return Service.class;
    }

    @Override
    public boolean existByServiceName(String serviceName) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(s) from Service s where s.serviceName = :serviceName ", Long.class);
        query.setParameter("serviceName", serviceName);
        return query.getSingleResult() > 0;
    }

    @Override
    public Optional<Service> findByServiceName(String serviceName) {
        TypedQuery<Service> query = entityManager.createQuery(
                "select s from Service s where s.serviceName = :serviceName", Service.class);
        query.setParameter("serviceName", serviceName);
        return Optional.ofNullable(query.getSingleResult());
    }
}
