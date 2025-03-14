package com.efexunn.user.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userRegisterToUser(UserRegisterRequest userRegisterRequest){
        return User.builder()
                .firstname(userRegisterRequest.getFirstname())
                .lastname(userRegisterRequest.getLastname())
                .email(userRegisterRequest.getEmail())
                .password(userRegisterRequest.getPassword())
                .role(Role.CUSTOMER)
                .build();
    }
}
