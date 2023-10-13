package org.example.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.user.command.CreateUser;
import org.example.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    //
    private final UserService userService;

    @PostMapping
    public String create(@RequestBody CreateUser command) {
        //
        return this.userService.create(command);
    }
}
