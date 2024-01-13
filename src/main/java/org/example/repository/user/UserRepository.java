package org.example.repository.user;

import org.example.base.repository.BaseRepository;
import org.example.entity.User;

public interface UserRepository<T extends User> extends BaseRepository<Integer,T> {
    void updatePassword(String email, String newPassword);
}
