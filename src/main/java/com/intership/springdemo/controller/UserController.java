package com.intership.springdemo.controller;

import com.intership.springdemo.service.UserService;
import com.intership.springdemo.service.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDto> getUsers(@RequestParam("firstName") String firstName) {
        return userService.getUsers(firstName);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUsers(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }
}
