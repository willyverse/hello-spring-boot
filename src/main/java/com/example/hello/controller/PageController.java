package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    // ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public UserDto user() {
        // var는 타입 추론이 가능함 (Java 11 부터 적용)
        var user = new UserDto();
        user.setName("willy");
        user.setAddress("seoul");
        return user;
    }
}
