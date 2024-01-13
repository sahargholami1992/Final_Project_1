package org.example.service.user;

import org.example.base.service.BaseService;
import org.example.entity.User;

public interface UserService<T extends User> extends BaseService<Integer,T> {
    void changePassword(String email, String newPassword);
}
