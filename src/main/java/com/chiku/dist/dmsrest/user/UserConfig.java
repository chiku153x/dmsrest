package com.chiku.dist.dmsrest.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository repository) {
        return args -> {
            User user = new User(1L, 1L, "superuser", "e@e.org", "@dM!n12345$$", "ROLE_ADMIN", true);
            final Optional<User> byId = repository.findById(1L);
            if(byId.isEmpty()) {
                repository.saveAll(List.of(user));
            }
        };
    }
}
