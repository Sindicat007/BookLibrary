package ru.maxima.booklibrary;

import org.springframework.boot.SpringApplication;

public class TestBookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookLibraryApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
