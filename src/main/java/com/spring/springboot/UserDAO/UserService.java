package com.spring.springboot.UserDAO;

import com.spring.springboot.Model.User;

import com.spring.springboot.Repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

private UserRepositories userRepositories;

    public UserService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    public void addUser(User user) {
       userRepositories.save(user);
    }

    public void deleteUser(Long id) {
        userRepositories.deleteById(id);

    }

    public void  editUser(User user) {
   userRepositories.saveAndFlush(user);
    }


    public User getUserById(Long id) {
        return userRepositories.findById(id).get();
    }


    public List<User> getAllUsers() {

        return userRepositories.findAll();
    }
}
