package com.example.spring_security_1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

//    @GetMapping("/hello-template")
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String hello() {
        return "hello-template.html";
    }
}
