package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String performLogin(@RequestParam String username, @RequestParam String password, Model model) {

        if ("admin".equals(username) && "20240140056".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username or Password incorrect");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(User user) {
        userList.add(user);
        return "redirect:/home";
    }
}