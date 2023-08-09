package com.github.commerce03.service;


import com.github.commerce03.repository.user.UserEntity;
import com.github.commerce03.repository.user.UserJpaRepository;
import com.github.commerce03.web.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserJpaRepository userJpaRepository;


    public UserEntity signup(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_email(user.getEmail());
        userEntity.setUser_password(user.getPassword());


        return userJpaRepository.save(userEntity);
    }
}
