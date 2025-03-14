package com.efexunn.user.user;

import com.efexunn.user.exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public NewUserResponse createUser(UserRegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistException("User already exists with this email : " + request.getEmail());
        }

        User newUser = userRepository.save(
                User.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        );

        return NewUserResponse.builder()
                .userId(newUser.getUserId())
                .firstname(newUser.getFirstname())
                .lastname(newUser.getLastname())
                .email(newUser.getEmail())
                .build();
    }
}
