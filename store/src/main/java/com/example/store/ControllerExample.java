package com.example.store;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ControllerExample {

    /*
    http://localhost:8080/ex1?id=abc
    ID: abc
    */
    @GetMapping("/ex1")
    public String ex1(@RequestParam String id) {
        return "ID: " + id;
    }

    /*
    http://localhost:8080/ex2/abc
    ID: abc
    */
    @GetMapping({"/ex2", "/ex2/{id}"})
    public String ex2(@PathVariable(required = false) String id){
        return "ID: " + id;
    }

    /*
    http://localhost:8080/ex3?name=josh&pwd=1234
    Name: Josh
    Password: 1234
    */
    @GetMapping("/ex3")
    public String ex3(@RequestParam Map<String, String> map) {
        String name = map.getOrDefault("name", "NA");
        String pwd = map.getOrDefault("pwd", "NA");
        return "Name: "+ name + "<br>Password: "+pwd;
    }

    /*
    http://localhost:8080/ex4
    POST with head/body
    */
    @PostMapping("/ex4")
    public String ex4(@RequestHeader("Authorization") String head, @RequestBody String body) {
        return "Head: "+ head + "<br> body: "+body;
    }

    @PostMapping("/ex5")
    public String ex5(@RequestBody Map<String, String> map) {
        return  map.getOrDefault("name", "No Name") +
                map.getOrDefault("pwd", "No Password");
    }

    /*
    Model Attribute
    The @ModelAttribute annotation can be used in a number of different ways in Spring MVC.
    One common use case is to bind form data to a JavaBean object.
    For example, if you have a form with input fields for a user’s first name, last name, and email.
    you can use the @ModelAttribute annotation to bind that data to a User object.
    Another use case for the @ModelAttribute annotation is to retrieve data from a database
    and add it to the model. For example, you could use the @ModelAttribute annotation
    to retrieve a list of users from a database and add it to the model
    so that it can be displayed in a view.
     */
}
