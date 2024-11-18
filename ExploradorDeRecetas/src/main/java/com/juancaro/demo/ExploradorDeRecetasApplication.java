package com.juancaro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.juancaro")
public class ExploradorDeRecetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExploradorDeRecetasApplication.class, args);
	}

}
