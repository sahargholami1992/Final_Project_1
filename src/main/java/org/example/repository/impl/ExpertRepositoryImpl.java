package org.example.repository.impl;

import org.example.entity.Expert;
import org.example.repository.ExpertRepository;
import org.example.repository.user.UserRepositoryImpl;

import javax.persistence.EntityManager;

public class ExpertRepositoryImpl extends UserRepositoryImpl<Expert>
                               implements ExpertRepository {
    public ExpertRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Expert> getEntityClass() {
        return Expert.class;
    }
}
