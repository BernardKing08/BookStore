package com.OnlineBookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.OnlineBookStore.Repository")
@EntityScan("com.OnlineBookStore.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class OnlineBookStoreApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreApplication2.class, args);
	}

}
