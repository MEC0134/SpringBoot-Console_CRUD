package com.luv2code.studentmansys;

import com.luv2code.studentmansys.dao.StudentDAO;
import com.luv2code.studentmansys.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class StudentManSysApplication {

	Menu m = new Menu();

	public static void main(String[] args) {
		SpringApplication.run(StudentManSysApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {

			m.Instructions();

			while (true) {

				String userChoice = m.mainMenuChoice();

				if (userChoice.equalsIgnoreCase("c")) {
					m.createStudent(studentDAO);
				} else if (userChoice.equalsIgnoreCase("r")) {
					m.findStudent(studentDAO);
				} else if (userChoice.equalsIgnoreCase("u")) {
					m.updateRecord(studentDAO);
				} else if (userChoice.equalsIgnoreCase("d")) {
					m.deleteStudent(studentDAO);
				} else {
					System.out.println("Please enter a valid input. Must be one of the following letters: C, R, U, D");
					continue;
				}


				int choice = m.keepGoing();
				if(choice == 0) {
					System.out.println("Thanks for using STUDMAN");
					exit(0);
				}



			}


		};
	}


}
