package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto, @PathVariable(name = "userId") Long id) {
        System.out.println(putRequestDto.toString());
        System.out.println(id);
        return putRequestDto;
    }
}
