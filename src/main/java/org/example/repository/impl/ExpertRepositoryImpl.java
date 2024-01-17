package org.example.repository.impl;

import org.example.entity.Expert;
import org.example.entity.enumaration.ExpertStatus;
import org.example.entity.enumaration.Permission;
import org.example.repository.ExpertRepository;
import org.example.repository.user.UserRepositoryImpl;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ExpertRepositoryImpl extends UserRepositoryImpl<Expert>
                               implements ExpertRepository {
    public ExpertRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Expert> getEntityClass() {
        return Expert.class;
    }

    @Override
    public void updateExpert(Expert expert) {
        beginTransaction();
        Query query = entityManager.createQuery("update Expert e set e.expertStatus = :expertStatus , e.permission= :permission where e.email= :email");
        query.setParameter("expertStatus", ExpertStatus.ACCEPTED);
        query.setParameter("permission", Permission.ACCEPTED);
        query.setParameter("email", expert.getEmail());
        query.executeUpdate();
        commitTransaction();
    }

}
