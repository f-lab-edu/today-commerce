package com.example.today_commerce.user.controller;

import com.example.today_commerce.user.dto.UserSignUpRequestDto;
import com.example.today_commerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        userService.signUp(userSignUpRequestDto);
    }
}
