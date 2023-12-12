package ma.thymeleaf.dem.demothymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.thymeleaf.dem.demothymeleaf.entities")
@EnableJpaRepositories(basePackages = "ma.thymeleaf.dem.demothymeleaf.repositories")
@ComponentScan(basePackages = {"ma.thymeleaf.dem.demothymeleaf.controller"})
public class DemothymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemothymeleafApplication.class, args);
	}

}
