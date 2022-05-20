package tn.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}
	@Bean
		ApplicationRunner init(CourseRepository repository) {
		Course c1 = new Course(1,"Python","Get started with Python Basics","en,fr");
		Course c2 = new Course(1,"Spring Boot","Get started with Spring Boot tools","en");
		Course c3 = new Course(1,"ReactJs","Get started with FrontEnd dev with angularJs","en,tn");
		return args -> {
			Stream.of(c1,c2,c3).forEach(course -> {
				repository.save(course);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
