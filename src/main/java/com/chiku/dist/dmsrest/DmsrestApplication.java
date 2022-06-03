package com.chiku.dist.dmsrest;

import com.chiku.dist.dmsrest.document.DocumentMeta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DmsrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmsrestApplication.class, args);
	}


	@GetMapping
	public List<String> welcome(){
		return List.of("Welcome to DMS RESTFull service");
	}

}
