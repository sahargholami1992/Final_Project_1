package org.example.repository.user;

import org.example.base.repository.BaseRepository;
import org.example.entity.User;

import java.util.Optional;

public interface UserRepository<T extends User> extends BaseRepository<Integer,T> {
    void updatePassword(String email, String newPassword);

    boolean existByEmail(String email);
    Optional<User> findByEmail(String email);
}
