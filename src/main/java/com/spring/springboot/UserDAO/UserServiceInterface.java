package com.spring.springboot.UserDAO;

import com.spring.springboot.Model.User;

import java.util.List;

public interface UserServiceInterface {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
