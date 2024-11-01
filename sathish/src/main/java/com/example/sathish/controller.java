package com.example.sathish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sathish.modules.User;
import com.example.sathish.repository.UserRepository;

@Controller
public class controller {
    private List<User> users = null; // Initialized to null

    private final UserRepository userRepository;

    @Autowired
    public controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", users);
        return "home";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/submit_signup")
    public String handleSignup(
            @RequestParam("aadhar") String aadhar,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("place") String place) {
        userRepository.save(new User(aadhar, name, email, place));
        userRepository.findAll().forEach(System.out::println);
        return "redirect:/login";
    }

    @PostMapping("/submit_login")
    public String getUserByName(@RequestParam("aadhar") String aadhar, Model model) {
        users = userRepository.findByAadhar(aadhar);
        model.addAttribute("users", users);
        
        if (users.isEmpty()) {
            model.addAttribute("fail", "You don't have an account");
            return "login";  // Return "login" view directly
        } else {
            return "home";   // Return "home" view directly
        }
    }
}
