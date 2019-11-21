package com.mvx.springboottesting.controllers;

import com.mvx.springboottesting.entities.User;
import com.mvx.springboottesting.usecases.UsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    private UsersUseCase useCase;

    @GetMapping("/users")
    public List<User> allUser() {
        List<User> users = new ArrayList<>();
        users.addAll(useCase.findAll());
        return users;
    }
}
