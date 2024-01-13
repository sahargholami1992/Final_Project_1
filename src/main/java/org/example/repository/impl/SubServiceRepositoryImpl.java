package org.example.repository.impl;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Expert;
import org.example.entity.SubService;
import org.example.repository.SubServiceRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    public void deleteByEXPERT(SubService subService, Expert expert) {

    }

    @Override
    public void saveExpert(SubService subService, Expert expert) {

    }

    @Override
    public void updateSubService(String subServiceName, double price, String description) {
        Query query = entityManager.createQuery("UPDATE SubService su set su.basePrice = :price, su.description = :description where su.subServiceName = :subServiceName");
        query.setParameter("subServiceName",subServiceName);
        query.setParameter("price",price);
        query.setParameter("description",description);
        query.executeUpdate();
    }
}
