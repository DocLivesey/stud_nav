package com.example.stud_nav.web;

import com.example.stud_nav.data.Course;
import com.example.stud_nav.data.News;
import com.example.stud_nav.data.Role;
import com.example.stud_nav.data.User;
import com.example.stud_nav.data.repos.CourseRepo;
import com.example.stud_nav.data.repos.NewsRepo;
import com.example.stud_nav.data.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private NewsRepo newsRepo;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/news")
    public String news(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable)
    {

        Page<News> news = newsRepo.findAll(pageable);
        int num=news.getTotalPages();
        model.addAttribute("news",news);
        model.addAttribute("url","/news");
        return "news";
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

    @Autowired
    private CourseRepo courseRepo;


    @RequestMapping("/show_course")
    public String showCourse(
            @RequestParam String filter,
            Model model
    ){
        List<Course> courses = courseRepo.findAllBySpeciality(filter);
        model.addAttribute("courses",courses);
        model.addAttribute("filter",filter);
        return "search";
    }
}
