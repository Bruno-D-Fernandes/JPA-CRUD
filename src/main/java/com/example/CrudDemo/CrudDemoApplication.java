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
			findAll(studentDAO);

//			updateStudent(studentDAO);
		};

	}


	private void CreateStudent(StudentDAO studentDAO) {
		Student pedro = new Student("a", "v", "a");
		studentDAO.save(pedro);

		System.out.println("Student created successfully");
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(2);

		student.setFirstName("Bruno");
		student.setEmail("Bruno@gmail.com");

		studentDAO.update(student);

		System.out.println(studentDAO.findById(2));
	}

	private void findStudentById(StudentDAO studentDAO) {
		Student student = studentDAO.findById(2);

		System.out.println("Student found successfully");
		System.out.println(student);
	}

	private void findAll(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student student : students) {
			System.out.println(student);
		}
	}
}
