package org.example.repository.user;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<Integer,T>
                                              implements UserRepository<T>{

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public void updatePassword(String email, String newPassword){
        Query query = entityManager.createQuery("UPDATE " + getEntityClass().getSimpleName() + " u SET u.password=:newPassword WHERE u.email = :email ");
        query.setParameter("email",email);
        query.setParameter("password",newPassword);
        query.executeUpdate();
    }
}
