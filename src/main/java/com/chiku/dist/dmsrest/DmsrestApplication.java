package com.chiku.dist.dmsrest;

import com.chiku.dist.dmsrest.uploadingfiles.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.chiku.dist.dmsrest.uploadingfiles.storage.StorageProperties;
import com.chiku.dist.dmsrest.uploadingfiles.storage.StorageService;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(StorageProperties.class)
public class DmsrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmsrestApplication.class, args);
	}


	@GetMapping
	public List<String> welcome(){
		return List.of("Welcome to DMS RESTFull service");
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}

}
