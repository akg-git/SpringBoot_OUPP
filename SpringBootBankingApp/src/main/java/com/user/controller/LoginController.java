package com.user.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.model.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    // You can handle login POST requests and authentication here if needed
    @PostMapping("/login")
    public String processLogin() {
        // Add your authentication logic here
        return "redirect:/user";
    }
}

