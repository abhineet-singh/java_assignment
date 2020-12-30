package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Tour;
import com.example.demo.ifaces.TourRepository;

@SpringBootApplication
public class TourRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourRestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			TourRepository repo;
			
			@Override
			public void run(String ...args) {
				
				repo.save(new Tour(100,"simla",4,56000));
			}
		};

	}
}
