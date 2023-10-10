package com.example.beispielprojekt.controller;

import com.example.beispielprojekt.BeispielProjektApplication.SaySomethingSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaySomethingController {
    @Autowired
    SaySomethingSevice saySomethingSevice;

    @GetMapping("/")
    public String home() {
        return saySomethingSevice.saySomething();
    }
}
