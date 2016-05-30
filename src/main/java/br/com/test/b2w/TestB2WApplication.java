package br.com.test.b2w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestB2WApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestB2WApplication.class, args);
	}
}
