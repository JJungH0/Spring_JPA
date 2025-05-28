package com.nhnacademy.springbootjpa.controller;

import com.nhnacademy.springbootjpa.entity.User;
import com.nhnacademy.springbootjpa.error.ResourceNotFoundException;
import com.nhnacademy.springbootjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class GetUserController {
//    private UserRepository repository;

    // DomainClassConverter를 이용한 API
    // TODO #1: DomainClassConverter를 이용해서 path variable로 Entity를 받음
    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") Optional<User> optionalUser) {
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // 기존에 해야하는 API
//    @GetMapping("/users/{id}")
//    public User getById2(@PathVariable("id") String id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
//    }
}
