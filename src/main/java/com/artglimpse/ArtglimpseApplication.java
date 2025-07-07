package com.artglimpse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "https://artglimpse-seller.vercel.app", "https://artglimpse.vercel.app" })
@SpringBootApplication
public class ArtglimpseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtglimpseApplication.class, args);
	}

}
