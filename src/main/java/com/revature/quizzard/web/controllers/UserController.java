package com.revature.quizzard.web.controllers;

import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.dtos.QuizzardHttpStatus;
import com.revature.quizzard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.exceptions.ResourcePersistenceException;
import com.revature.quizzard.entities.User;
import com.revature.quizzard.services.UserService;
import com.revature.quizzard.util.ErrorResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/id/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void createNewUser(@RequestBody User newUser) {
        userService.register(newUser);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException e) {
        return ErrorResponseFactory.getInstance().generateErrorResponse(QuizzardHttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleResourcePersistenceException(ResourcePersistenceException e) {
        return ErrorResponseFactory.getInstance().generateErrorResponse(QuizzardHttpStatus.CONFLICT);
    }

    // Included for posterity
//    @GetMapping(path = "/id/{id}/something/{stf}")
//    public User getUserById(@PathVariable int id, @PathVariable("stf") String stuff) {
//        System.out.println("id provided: " + id);
//        System.out.println("stuff provided: " + stuff);
//        return new User("wsingleton", "password", "wsingleton@revature.com", "Wezley", "Singleton", Role.ADMIN);
//    }

//    @GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
//    public User getUserById(@RequestParam int id, @RequestParam("stf") String stuff) {
//        if (id <= 0) {
//            throw new ResourceNotFoundException();
//        }
//        System.out.println("id provided: " + id);
//        System.out.println("stuff provided: " + stuff);
//        return new User("wsingleton", "password", "wsingleton@revature.com", "Wezley", "Singleton", Role.ADMIN);
//    }
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public User createNewUser(@RequestBody User newUser, @RequestHeader String someHeader) {
//        System.out.println(newUser);
//        System.out.println(someHeader);
//        return newUser;
//    }
}
