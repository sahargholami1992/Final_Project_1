package org.example.service.user;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.User;
import org.example.repository.user.UserRepository;

import javax.persistence.NoResultException;

public class UserServiceImpl<T extends User,R extends UserRepository<T>> extends BaseServiceImpl<Integer,T,R>
                                   implements UserService<T>{
    public UserServiceImpl(R repository) {
        super(repository);
    }


    @Override
    public void changePassword(String email, String newPassword) {
        repository.updatePassword(email,newPassword);
    }

    @Override
    public boolean existByEmail(String email) {
        return repository.existByEmail(email);
    }

    @Override
    public T logIn(String email, String password) {
        T user = repository.findByEmail(email).
                orElseThrow(() -> new NullPointerException("userName or password is wrong"));

        if (password.equals(user.getPassword())){
            return user;
        }
        throw new NoResultException("userName or password is wrong");

    }
}
