package com.chiku.dist.dmsrest.config;

import com.chiku.dist.dmsrest.model.User;
import com.chiku.dist.dmsrest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository repository, PasswordEncoder encoder) {
        return args -> {
            User user = new User(1L, 1L, "superuser", "e@e.org", encoder.encode("@dM!n12345$$"), "ROLE_ADMIN", true);
            final Optional<User> byId = repository.findUserByUserName("superuser");
            if(byId.isEmpty()) {
                repository.saveAll(List.of(user));
            }
        };
    }
}
