package com.luv2code.studentmansys;

import com.luv2code.studentmansys.dao.StudentDAO;
import com.luv2code.studentmansys.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class StudentManSysApplication {

	// Fields

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(StudentManSysApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {

			if(Instructions().equalsIgnoreCase("c")) {
				createStudent(studentDAO);
			}

		};
	}


	private String Instructions() {
		System.out.println("*************************************************************");
		System.out.println("Welcome to STUDMAN - Your Favorite Student Management Software. " +
				"\nPlease choose carefully from below menu what you would like to do.");
		System.out.println("*************************************************************");
		System.out.println("Please press: \nC to create new student\nR to see a student using name or id\nU to update a record for a student" +
				"\nD to delete a student record using name or id");
		String menuChoice = sc.nextLine();
		return menuChoice;
	}


	    void createStudent(StudentDAO studentDAO) {

        System.out.println("Please enter the student id (Must be 9 digits):");
        int studId = sc.nextInt();

		sc.nextLine();


		System.out.println("Please enter the students first name:");
        String fName = sc.nextLine();
        System.out.println("Please enter the students last name:");
        String lName = sc.nextLine();
        System.out.println("Please enter the email");
        String email = sc.nextLine();

        Student tempStudent = new Student(studId, fName, lName, email);


        System.out.println("Saving new student to database....");
        studentDAO.createStudent(tempStudent);

        System.out.println("Saved student id: " + tempStudent.getStudId());
    }
}
