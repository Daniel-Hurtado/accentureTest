package com.accenture.api.test.store;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	
	/**
     * Metodo que define un Bean de configuración para la documentacion de Apis con Swagger
     * 
     * @return Objecto configurado para la documentación con Swagger
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false).apiInfo(apiInfo());
    }

    /**
     * Metodo que permite definir la información general que aplica a todas las Apis expuestas en este proyecto
     * 
     * @return Objeto con la informacion de las Apis
     */
    private ApiInfo apiInfo() {
        return new ApiInfo("Core Rest service", "Documentación de las Apis", "1.0",
                "Visita https://example.com/terms",
                new Contact("Daniel Alejandro Hurtado", "n/a", "daniel_alejo96@hotmail.com"), "License",
                "n/a", Collections.emptyList());
    }
}
