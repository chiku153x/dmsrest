package com.chiku.dist.dmsrest;

import com.chiku.dist.dmsrest.config.RsaKeyProperties;
import com.chiku.dist.dmsrest.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.chiku.dist.dmsrest.config.StorageProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableConfigurationProperties({StorageProperties.class, RsaKeyProperties.class})
@EnableSwagger2
public class DmsrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmsrestApplication.class, args);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<String> welcome() {
        return List.of("Welcome to DMS RESTFull service");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/xx")
    public List<String> welcome2() {
        return List.of("Welcome to DMS RESTFull service 3333");
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }

}
