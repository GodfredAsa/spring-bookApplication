package io.degreat.bookApplication.Service.Iservice;

import io.degreat.bookApplication.Model.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    //    change Role
    void makeAdmin(String username);
}
