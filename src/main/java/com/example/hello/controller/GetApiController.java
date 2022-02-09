package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:8080/api/get/hello
    public String hello() {
        return "hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVarible(@PathVariable String name) {
        System.out.println("PathVariable: " + name);
        return name;
    }

    @GetMapping("/path-variable-2/{name}") // PathVariable의 parameter와 uri를 동명으로 쓸 수 없는 경우!
    public String pathVarible2(@PathVariable(name = "name") String anyName) {
        System.out.println("PathVariable: " + anyName);
        return anyName;
    }

    // http://localhost:8080/api/get/query-param?user=willy&email=willy@kim.com&age=28
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // param을 명시적으로 나타낼 경우
    @GetMapping("/query-param-2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // ?user=willy&email=willy@kim.com&age=28&address=서울시
    // param을 미리 만들어 둔 dto로 나타낼 경우
    @GetMapping("/query-param-3") // 이런 경우 @RequestParam 어노테이션은 붙이지 않음!
    public String queryParam2(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
