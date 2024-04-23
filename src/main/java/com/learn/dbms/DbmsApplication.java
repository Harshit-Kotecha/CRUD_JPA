package com.learn.dbms;

import com.learn.dbms.dao.StudentDAO;
import com.learn.dbms.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DbmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DbmsApplication.class, args);


	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);

//			readStudent(studentDAO);

//			queryStudents(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting students " + studentDAO.deleteStudents("Scooby"));
	}

	private void updateStudent(StudentDAO studentDAO) {
		studentDAO.updateStudent(1);

		queryStudents(studentDAO);
	}

	private void queryStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getAll();
		for(Student student : students) {
			System.out.println(student.toString());
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student");
		Student student  = new Student("Roman", "Jain", "hr@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		System.out.println("Student id is " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student");
		Student student  = new Student("John", "Jain", "h@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		System.out.println("Student id is " + student.getId());

		System.out.println("Fetching the student");
		System.out.println(studentDAO.readById(student.getId()).toString());
	}

}
