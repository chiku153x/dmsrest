package com.chiku.dist.dmsrest.service;

import com.chiku.dist.dmsrest.model.User;
import com.chiku.dist.dmsrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void addNewUser(User user) {
        List<User> users = userRepository.findAll()
                .stream()
                .filter(f -> f.getUserName().equals(user.getUserName()))
                .toList();
        if (!users.isEmpty()) {
            user.setId(users.get(0).getId());
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public List<User> getUserById(Long userId) {
        return userRepository.findAll().stream().filter(f -> f.getUserId().longValue() == userId.longValue()).collect(Collectors.toList());
    }
}
