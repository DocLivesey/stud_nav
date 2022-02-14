package com.example.stud_nav.web;

import com.example.stud_nav.data.Role;
import com.example.stud_nav.data.User;
import com.example.stud_nav.data.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class WebController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }



    @GetMapping("/user")
    public String user(){
        return ("Welcome User");
    }

    @GetMapping("/registration")
    public String register(){
        return "register";
    }


    @Autowired
    private UsersRepo usersRepo;

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDb = usersRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("user exist");
        }
        user.setRoles(Collections.singleton(Role.USER));
        usersRepo.save(user);

        return "redirect:/login";
    }
}
