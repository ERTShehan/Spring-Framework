package lk.ijse.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
