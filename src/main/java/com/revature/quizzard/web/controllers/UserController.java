package com.revature.quizzard.web.controllers;

import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.dtos.QuizzardHttpStatus;
import com.revature.quizzard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.models.Role;
import com.revature.quizzard.models.User;
import com.revature.quizzard.util.ErrorResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(HttpServletRequest req) {
        System.out.println(req); // Spring gives you a facade object for lower-level objects from the Servlet API
        System.out.println(req.getAttribute("example-attribute"));
        List<User> exampleUsers = new ArrayList<>();
        exampleUsers.add(new User("wsingleton", "password", "wsingleton@revature.com", "Wezley", "Singleton", Role.ADMIN));
        exampleUsers.add(new User("skelsey", "p4ssw0rd", "skelsey@revature.com", "Steven", "Kelsey", Role.PREMIUM_USER));
        exampleUsers.add(new User("njurczak", "drowssap", "njurczak@revature.com", "Nickolas", "Jurczak", Role.DEV));
        return exampleUsers;
    }

//    @GetMapping(path = "/id/{id}/something/{stf}")
//    public User getUserById(@PathVariable int id, @PathVariable("stf") String stuff) {
//        System.out.println("id provided: " + id);
//        System.out.println("stuff provided: " + stuff);
//        return new User("wsingleton", "password", "wsingleton@revature.com", "Wezley", "Singleton", Role.ADMIN);
//    }

    @GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@RequestParam int id, @RequestParam("stf") String stuff) {
        if (id <= 0) {
            throw new ResourceNotFoundException();
        }
        System.out.println("id provided: " + id);
        System.out.println("stuff provided: " + stuff);
        return new User("wsingleton", "password", "wsingleton@revature.com", "Wezley", "Singleton", Role.ADMIN);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User createNewUser(@RequestBody User newUser, @RequestHeader String someHeader) {
        System.out.println(newUser);
        System.out.println(someHeader);
        return newUser;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return ErrorResponseFactory.getInstance().generateErrorResponse(QuizzardHttpStatus.NOT_FOUND);
    }

}
