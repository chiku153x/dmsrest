package com.chiku.dist.dmsrest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        List<User> users = userRepository.findAll()
                .stream()
                .filter(f -> f.getUserName().equals(user.getUserName())                        )
                .toList();
        if (!users.isEmpty()) {
            user.setId(users.get(0).getId());
        }
        userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public List<User> getUserById(Long userId) {
        return userRepository.findAll().stream().filter(f -> f.getUserId().longValue() == userId.longValue()).collect(Collectors.toList());
    }
}
