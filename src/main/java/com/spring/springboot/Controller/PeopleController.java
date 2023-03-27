package com.spring.springboot.Controller;

import com.spring.springboot.Model.User;
import com.spring.springboot.UserDAO.UserServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeopleController {
    private final UserServiceInterface userServiceInterface;

    public PeopleController(UserServiceInterface userServiceInterface) {

        this.userServiceInterface = userServiceInterface;
    }


    @GetMapping(value = "users")
    public String allUsers(Model model) {
        model.addAttribute("users", userServiceInterface.getAllUsers());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "users")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceInterface.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        User user = userServiceInterface.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userServiceInterface.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userServiceInterface.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, Model modelMap) {
        modelMap.addAttribute("user", userServiceInterface.getUserById(id));
        return "show";
    }

}