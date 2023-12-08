package com.citasmedicas.aplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.citasmedicas")
public class SpringBootFacebookLoginAppApplication {
	
  
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFacebookLoginAppApplication.class, args);
	}
}
