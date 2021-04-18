package com.viajesInterdep.viajesInterdep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "Controller", "Service", "Repository" })
public class ViajesInterdepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViajesInterdepApplication.class, args);
	}

}
