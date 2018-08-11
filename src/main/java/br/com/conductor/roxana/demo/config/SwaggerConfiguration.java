package br.com.conductor.roxana.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	private static final String BASE_RESOURCES_PACKAGE = "br.com.conductor.roxana.demo";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_RESOURCES_PACKAGE)).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("Roxana Demo");
		builder.description("A demo project for Roxana Framework.");
		builder.contact(this.getContato());
		return builder.build();
	}
	
	private Contact getContato() {
		return new Contact("Roxana Framework", "https://github.com/rooting-company/roxana", "brunoluisncosta@gmail.com");
	}

}