package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Print {
    @RequestMapping("judge")
    public String print(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", "admin");
        return "book";
    }
}
