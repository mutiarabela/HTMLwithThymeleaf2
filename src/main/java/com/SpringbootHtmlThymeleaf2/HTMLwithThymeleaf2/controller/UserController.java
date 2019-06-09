package com.SpringbootHtmlThymeleaf2.HTMLwithThymeleaf2.controller;

import com.SpringbootHtmlThymeleaf2.HTMLwithThymeleaf2.entity.User;
import com.SpringbootHtmlThymeleaf2.HTMLwithThymeleaf2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "view-user";
    }

    @GetMapping("/index")
    public String listUsers(@Valid User user, BindingResult result, Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}

