package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value: " + value);
        });
    }

    @PostMapping("/post/dto") // post request dto는 @RequestBody를 붙여줘야 함
    public void postDto(@RequestBody PostRequestDto postRequestDto) {
        System.out.println(postRequestDto.toString());
    }
}
