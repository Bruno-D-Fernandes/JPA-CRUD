package com.example.CrudDemo;

import com.example.CrudDemo.dao.StudentDAO;
import com.example.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}


	@Bean					//por que funciona com String[] args?
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return Runner -> {
//			CreateStudent(studentDAO);
//			findStudentById(studentDAO);
//			findAll(studentDAO);
//			updateStudent(studentDAO);
		};

	}
}
