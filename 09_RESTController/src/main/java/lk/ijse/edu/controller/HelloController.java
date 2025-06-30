package lk.ijse.edu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("HelloController Constructor");
    }

    @GetMapping()
    public String sayHello() {
        return "Hello world!";
    }

    @PostMapping
    public String sayHelloPost() {
        return "Say Post";
    }

    @PutMapping
    public String sayHelloPut() {
        return "Say Put";
    }

    @DeleteMapping
    public String sayHelloDelete() {
        return "Say Delete";
    }

    @PatchMapping
    public String sayHelloPatch() {
        return "Say Patch";
    }
}
