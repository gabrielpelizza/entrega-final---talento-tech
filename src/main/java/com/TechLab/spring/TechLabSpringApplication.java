package com.TechLab.spring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechLabSpringApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		String dbpassword = dotenv.get("SQL_PASSWORD");

		if (dbpassword != null){
			System.setProperty("SQL_PASSWORD", dbpassword);
		}
		SpringApplication.run(TechLabSpringApplication.class, args);
	}

}
