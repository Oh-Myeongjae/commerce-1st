package com.github.commerce03.service;


import com.github.commerce03.repository.user.UserEntity;
import com.github.commerce03.repository.user.UserJpaRepository;
import com.github.commerce03.web.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;


    public UserEntity signup(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(user.getEmail());

        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        userEntity.setUserPassword(encryptedPassword);


        return userJpaRepository.save(userEntity);
    }

    public UserEntity findByEmail(String email) {
        return userJpaRepository.findByUserEmail(email);
    }
}
