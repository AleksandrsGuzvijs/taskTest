package aleks.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication(scanBasePackages = "aleks")
public class TaskTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTestApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("aleks.exercise.web"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Task Manager API",
				"2nd test application for managing tasks",
				"1.0",
				null,
				new springfox.documentation.service.Contact("Aleksandrs Guzvijs",null,"aleks.guzvijs@yandex.ru"),
				null,
				null,
				Collections.emptyList());
	}
}
