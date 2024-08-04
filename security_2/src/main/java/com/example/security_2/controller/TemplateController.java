package com.example.security_2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

//    @GetMapping("/hello-template")
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('USER')")
    public String hello() {
        return "hello-template.html";
    }
}
