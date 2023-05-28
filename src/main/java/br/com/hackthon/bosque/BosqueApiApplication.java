package br.com.hackthon.bosque;

import br.com.hackthon.bosque.infrastructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class BosqueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BosqueApiApplication.class, args);
	}

}
