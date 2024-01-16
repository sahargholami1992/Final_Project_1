package org.example.repository.user;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.entity.Service;
import org.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

public abstract class UserRepositoryImpl<T extends User> extends BaseRepositoryImpl<Integer,T>
                                              implements UserRepository<T>{

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public void updatePassword(String email, String newPassword){
        beginTransaction();
        Query query = entityManager.createQuery("UPDATE " + getEntityClass().getSimpleName() + " u SET u.password=:newPassword WHERE u.email = :email ");
        query.setParameter("email",email);
        query.setParameter("newPassword",newPassword);
        query.executeUpdate();
        commitTransaction();
    }

    @Override
    public boolean existByEmail(String email) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(u) from " + getEntityClass().getSimpleName() + " u WHERE u.email =:email ", Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }
    @Override
    public Optional<User> findByEmail(String email){
        TypedQuery<User> query = entityManager.createQuery(
                "select u from " + getEntityClass().getSimpleName() + " u WHERE u.email =:email ", User.class);
        query.setParameter("email", email);
        return Optional.ofNullable(query.getSingleResult());
    }
}
