package org.example.service.user;

import org.example.base.service.BaseServiceImpl;
import org.example.entity.User;
import org.example.repository.user.UserRepository;

public class UserServiceImpl<T extends User,R extends UserRepository<T>> extends BaseServiceImpl<Integer,T,R>
                                   implements UserService<T>{
    public UserServiceImpl(R repository) {
        super(repository);
    }


    @Override
    public void changePassword(String email, String newPassword) {
        repository.updatePassword(email,newPassword);
    }
}
