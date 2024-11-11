package com.juancaro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.juancaro")
public class LibrosYAutoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrosYAutoresApplication.class, args);
	}

}
