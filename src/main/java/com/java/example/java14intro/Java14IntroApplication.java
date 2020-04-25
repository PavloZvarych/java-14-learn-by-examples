package com.java.example.java14intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this app has multiple self-containing java files,
 * that demonstrate java 14 features;
 * spring boot was introduced for jPackage
 * can be removed if it doesn't work with it
 */
@SpringBootApplication
public class Java14IntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java14IntroApplication.class, args);
	}

}
