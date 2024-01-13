package org.example.repository.impl;

import org.example.entity.Admin;
import org.example.repository.AdminRepository;
import org.example.repository.user.UserRepositoryImpl;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends UserRepositoryImpl<Admin>
                               implements AdminRepository {
    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
