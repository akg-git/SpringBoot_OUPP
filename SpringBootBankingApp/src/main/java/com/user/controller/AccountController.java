package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.model.Account;
import com.user.model.User;
import com.user.repository.AccountRepository;
import com.user.repository.UserRepository;

@Controller
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/balance")
    public String viewBalance(Model model, @RequestParam("userId") Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        
        if (user == null) {
            // Handle user not found
            return "redirect:/error";
        }

        Account account = accountRepository.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("account", account);
        return "balance";
    }

    @PostMapping("/transfer")
    public String transferMoney(@RequestParam("userId") Long userId, @RequestParam("amount") double amount) {
        User user = userRepository.findById(userId).orElse(null);
        
        if (user == null) {
            // Handle user not found
            return "redirect:/error";
        }

        Account account = accountRepository.findByUser(user);

        // Assuming positive amount is a deposit and negative amount is a withdrawal
        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);

        return "redirect:/balance?userId=" + userId;
    }

    @PostMapping("/withdraw")
    public String withdrawMoney(@RequestParam("userId") Long userId, @RequestParam("amount") double amount) {
        return processTransaction(userId, amount, false);
    }

    @PostMapping("/deposit")
    public String depositMoney(@RequestParam("userId") Long userId, @RequestParam("amount") double amount) {
        return processTransaction(userId, amount, true);
    }

    private String processTransaction(Long userId, double amount, boolean isDeposit) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            // Handle user not found
            return "redirect:/error";
        }

        Account account = accountRepository.findByUser(user);

        if (isDeposit) {
            account.setBalance(account.getBalance() + amount);
        } else {
            // Check if sufficient balance before withdrawal
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
            } else {
                // Handle insufficient balance
                // You may redirect to an error page or show a message
                return "redirect:/balance?userId=" + userId + "&error=insufficientBalance";
            }
        }

        accountRepository.save(account);

        return "redirect:/balance?userId=" + userId;
    }
}
