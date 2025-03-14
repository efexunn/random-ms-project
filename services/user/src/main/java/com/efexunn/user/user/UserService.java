package com.efexunn.user.user;

import com.efexunn.user.exceptions.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User createUser(UserRegisterRequest request) {
        return null;
    }
}
