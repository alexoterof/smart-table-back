package com.alexoterof.smartable;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alexoterof.smartable.dao.PersonaDao;
import com.alexoterof.smartable.modelo.Persona;

@SpringBootApplication
public class SmartTableBackApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SmartTableBackApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SmartTableBackApplication.class);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
				        .allowedOrigins("http://localhost:4200")
				        .allowedMethods("*")
				        .allowedHeaders("*");
	        }
		};
	}
	
	@Bean
	CommandLineRunner initData(PersonaDao heroDao) {
		return (args) -> {
			heroDao.saveAll(Arrays.asList(new Persona("Alex Otero", "alexoterof", "alexoterof@gmail.com", "Programador/a", false),
										new Persona("Juan pedro", "juanpe", "juanpe@foo.com", "Analista", true),
										new Persona("Ezequiel dios", "ezigod", "ezig0d@foo.com", "Director/a", false),
										new Persona("Lorena ferro", "lorefe", "lorefe@foo.com", "Programador/a", false),
										new Persona("Juana otero", "juanaOt", "juanaot@foo.com", "Programador/a", true),
										new Persona("David otero", "davido", "davido@foo.com", "Programador/a", true),
										new Persona("Gabriel dios", "gabrid", "gabrid@foo.com", "Programador/a", false),
										new Persona("Lorena dios", "lored", "lored@foo.com", "Programador/a", false),
										new Persona("Julio cesar", "caesarxd", "caesar@foo.com", "Mantenimiento", true)
	                                        ));
		};	
	}
}
