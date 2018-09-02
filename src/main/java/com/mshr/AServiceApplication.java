package com.mshr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class AServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AServiceApplication.class, args);

	}

	@GetMapping("/my/{id}")
	public Person g(@PathVariable("id") Integer id) {

		String url = "http://localhost:8081/persons/"+ id;

		RestTemplate restTemplate = new RestTemplate();

		Person p = restTemplate.getForObject(url, Person.class);

		System.out.println("Name " + id + " :" + p.getName());
		System.out.println("Id " + id + " :" + p.getName());
		return p;
	}

}
