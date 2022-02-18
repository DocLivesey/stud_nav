package com.example.stud_nav.web;

import com.example.stud_nav.data.News;
import com.example.stud_nav.data.Role;
import com.example.stud_nav.data.User;
import com.example.stud_nav.data.repos.NewsRepo;
import com.example.stud_nav.data.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private NewsRepo newsRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users",usersRepo.findAll());
        return "admin";
    }

    @GetMapping("{user}")
    public String userEdit (@PathVariable User user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "user_edit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String,String> form,
            @RequestParam("userId") User user
    ){
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();
        for (String key: form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        usersRepo.save(user);
        return "redirect:admin";
    }

    @PostMapping("/news")
    public String addNews (
            @RequestParam String header,
            @RequestParam String body
    ){
        News news = new News();
        news.setHeader(header);
        news.setBody(body);
        newsRepo.save(news);
        return "redirect:admin";
    }
}
