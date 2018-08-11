package br.com.conductor.roxana.demo;

import br.com.rooting.roxana.config.EnableRoxana;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableRoxana
@EnableSwagger2
@SpringBootApplication
public class RoxanaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoxanaDemoApplication.class, args);
	}
}
