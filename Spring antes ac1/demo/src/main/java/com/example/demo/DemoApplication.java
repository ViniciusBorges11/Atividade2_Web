package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import model.Agenda;
import model.Curso;

import repository.CursoRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
    public CommandLineRunner init() {
    return args -> {
	
	};
}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

