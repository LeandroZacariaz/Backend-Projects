package com.blogplatform.blogging_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Blogging Platform API",
        version = "1.0",
        description = "API REST para gestionar publicaciones de blogs",
        contact = @Contact(
            name = "Leandro Zacariaz",
            email = "leandrozacariaz18@gmail.com",
            url = "https://github.com/LeandroZacariaz"
        ),
        license = @License(
            name = "Unlicensed",
            url = "https://choosealicense.com/no-permission/"
        )
    )
)
public class BloggingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingApiApplication.class, args);
    }
}