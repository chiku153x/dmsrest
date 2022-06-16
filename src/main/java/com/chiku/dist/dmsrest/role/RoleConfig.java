package com.chiku.dist.dmsrest.role;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfig {
	@Bean
	CommandLineRunner commandLineRunner(RoleRepository repository){
		return args ->{
			Role superUserRole = new Role(1L,"Super User");
			Role supervisorRole = new Role(2L,"Supervisor");
			Role userRole = new Role(3L,"User");
			repository.saveAll(List.of(superUserRole,supervisorRole,userRole));
		};
	}
}
