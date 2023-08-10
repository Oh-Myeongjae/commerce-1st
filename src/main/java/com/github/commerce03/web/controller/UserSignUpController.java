package com.github.commerce03.web.controller;

import com.github.commerce03.config.Provider.JwtTokenProvider;
import com.github.commerce03.repository.user.UserEntity;
import com.github.commerce03.service.UserSignUpService;
import com.github.commerce03.web.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserSignUpController {

    private final UserSignUpService userSignUpService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(@RequestBody User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(user.getEmail());
        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        userEntity.setUserPassword(encryptedPassword);

        userSignUpService.signup(user);

        return ResponseEntity.ok("회원가입이 완료되었습니다.");

    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody User user, HttpServletResponse httpServletResponse) {
        // 로그인 로직
        UserEntity userEntity = userSignUpService.findByEmail(user.getEmail());

        if (userEntity != null && passwordEncoder.matches(user.getPassword(), userEntity.getUserPassword())) {
            // 로그인이 성공한 경우 JWT 토큰 발행
            String token = jwtTokenProvider.createToken(user.getEmail());
            httpServletResponse.setHeader("TOKEN",token);
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 정보가 올바르지 않습니다.");
        }

    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> userLogout(@RequestBody User user, HttpServletResponse response) {
        String email = user.getEmail();

        return ResponseEntity.ok(Map.of("message", "로그아웃되었습니다."));
    }





}
