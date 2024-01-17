package org.example.repository.impl;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Expert;
import org.example.entity.Service;
import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<Integer, SubService>
                               implements SubServiceRepository {
    public SubServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public void updateSubService(String subServiceName, double price, String description) {
        beginTransaction();
        Query query = entityManager.createQuery("UPDATE SubService su set su.basePrice = :price, su.description = :description where su.subServiceName = :subServiceName");
        query.setParameter("subServiceName",subServiceName);
        query.setParameter("price",price);
        query.setParameter("description",description);
        query.executeUpdate();
        commitTransaction();
    }

    @Override
    public Collection<SubService> findByService(Service service) {
        TypedQuery<SubService> query = entityManager.createQuery(
                "select su from SubService su where su.service = :service ",
                SubService.class);
        query.setParameter("service", service);
        return query.getResultList();
    }

    @Override
    public boolean existByName(String subServiceName) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(su) from SubService su where su.subServiceName = :subServiceName ", Long.class);
        query.setParameter("subServiceName", subServiceName);
        return query.getSingleResult() > 0;
    }
}
