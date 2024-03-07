package com.example.the2024exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.the2024exam.mapper")
public class The2024examApplication {

	public static void main(String[] args) {
		SpringApplication.run(The2024examApplication.class, args);
	}

}
