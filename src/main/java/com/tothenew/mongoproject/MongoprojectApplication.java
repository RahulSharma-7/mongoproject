package com.tothenew.mongoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoprojectApplication.class, args);
	}

}
