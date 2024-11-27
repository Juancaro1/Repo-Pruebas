package com.juancaro.examen2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.juancaro")
@EnableJpaRepositories("com.juancaro.repositorios")
@EntityScan("com.juancaro.modelos")
public class Examen2Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen2Application.class, args);
	}

}
