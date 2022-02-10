package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResponseApiController {

    // Text
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    //Json
    // request -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto userDto) {
        return userDto; // 200 OK
    }

    // ResponseEntity를 활용하면 response status를 확정적으로 내려줄 수 있음
    @PutMapping("/put")
    public ResponseEntity<UserDto> put(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

}