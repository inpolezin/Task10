package com.shivasj.springbootcrud.controller;

import com.shivasj.springbootcrud.model.User;
import com.shivasj.springbootcrud.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public String getAllUsersPage(Model model) {
        model.addAttribute("users", userServiceImpl.findAllUsers());
        return "users/all";
    }

    @GetMapping("/new")
    public String getCreateUserPage(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userServiceImpl.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getEditUserPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImpl.findUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImpl.updateUser(user);
        return "redirect:/users";
    }
}
