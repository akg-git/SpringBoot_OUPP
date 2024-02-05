package com.user.controller;

import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String createUserForm(Model model) {
    model.addAttribute("user", new User());
    return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Validation logic and user registration

        userRepository.save(user);

        // Redirect to the login page after successful registration
        return "redirect:/user";
    }

    
}

