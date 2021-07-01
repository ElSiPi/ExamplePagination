package com.example.pagination;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pagination.models.Course;
import com.example.pagination.repos.ICourseRepo;


@SpringBootApplication
public class PaginationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaginationExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner saveData(ICourseRepo cRepo) {

		return(args)->{
		Course c1 = new Course("Java", 4, "Pirmā pasniedzēja");
		Course c2 = new Course("Python", 2, "Otrā pasniedzēja");
		Course c3 = new Course("Matemātika", 4, "Trešā pasniedzēja");
		cRepo.save(c1);
		cRepo.save(c2);
		cRepo.save(c3);
		};
	}

}
