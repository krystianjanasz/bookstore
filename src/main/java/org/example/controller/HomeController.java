package org.example.controller;

import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(userService.isAdmin(auth.getName()));
        if(userService.isAdmin(auth.getName())){
            return "admin-index";
        }
        return "index";
    }
}
