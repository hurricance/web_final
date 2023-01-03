package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Jump {
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("book")
    public String book(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String user = (String) session.getAttribute("user");
//        if (user != null && user.equals("admin")) {
//            return "book";
//        } else {
//            return "login";
//        }
        return "book";
    }

    @RequestMapping("register")
    public String register(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String user = (String) session.getAttribute("user");
//        if (user != null && user.equals("admin")) {
//            return "register";
//        } else {
//            return "login";
//        }
        return "register";
    }
}
