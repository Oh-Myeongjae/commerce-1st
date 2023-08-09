package com.github.commerce03.web.controller;

import com.github.commerce03.repository.user.UserEntity;
import com.github.commerce03.service.UserSignUpService;
import com.github.commerce03.web.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserSignUpController {

    private final UserSignUpService userSignUpService;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(@RequestBody User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_email(user.getEmail());
        userEntity.setUser_password(user.getPassword()); // 암호화 필요

        userSignUpService.signup(user);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}
