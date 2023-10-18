package br.com.ifsp.boletim.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.ifsp.boletim.controller"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		return new ApiInfo(
							"Boletim API",
							"API responsável pelo retorno das informações referentes as notas.",
							"1.0",
							"Termos de serviço",
							new Contact("IFSP",
										"https://gru.ifsp.edu.br",
										"renan.carlos1@aluno.ifsp.edu.br"),
							"Apache License version 2.0",
							"https://www.apache.org/lisense.html",
							Collections.emptyList());
	}

}
