package com.example.stud_nav.web;

import com.example.stud_nav.data.News;
import com.example.stud_nav.data.Role;
import com.example.stud_nav.data.User;
import com.example.stud_nav.data.repos.NewsRepo;
import com.example.stud_nav.data.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class WebController {

    @Autowired
    private NewsRepo newsRepo;

    @RequestMapping("/")
    public String home(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable)
    {
        Iterable<News> news = newsRepo.findAll(pageable);
        model.addAttribute("news",news);
        return "home";
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
        user.setActive(true);
        usersRepo.save(user);

        return "redirect:/login";
    }
}
