package com.morimorig3.todoapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Todo API", version = "1.0.0", description = "TodoのCRUD操作を通してSpringframeworkを学習するAPIです"))
public class TodoappApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

}
