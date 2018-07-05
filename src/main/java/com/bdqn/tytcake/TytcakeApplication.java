package com.bdqn.tytcake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TytcakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TytcakeApplication.class, args);
	}
}
