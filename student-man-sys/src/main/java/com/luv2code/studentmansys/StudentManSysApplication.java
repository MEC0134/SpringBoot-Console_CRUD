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

			String userChoice = Instructions();

			if(userChoice.equalsIgnoreCase("c")) {
				createStudent(studentDAO);
			} else if(userChoice.equalsIgnoreCase("r")) {
				findStudent(studentDAO);
			} else if (userChoice.equalsIgnoreCase("u")) {
				updateRecord(studentDAO);
			}

			System.out.println("Student Updated!");

		};
	}


	private String Instructions() {

		System.out.println("*************************************************************");
		System.out.println("Welcome to STUDMAN - Your Favorite Student Management Software. " +
				"\nPlease choose carefully from below menu what you would like to do.");
		System.out.println("*************************************************************");
		System.out.println("Please press: \nC - to create new student\nR - to see student information \nU - to update a record for a student" +
				"\nD - to delete a student record using name or id");
		String menuChoice = sc.nextLine();
		return menuChoice;

	}


	// Create

	private void createStudent(StudentDAO studentDAO) {

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

	// Read

	private void findStudent(StudentDAO studentDAO) {

		System.out.println("Please enter the student id: ");
		Integer id = sc.nextInt();

		Student studentFound = studentDAO.readStudent(id);
		System.out.println(studentFound);
	}


	// Update

	private void updateRecord(StudentDAO studentDAO) {

		System.out.println("Please enter the id of the student you want to make changes for: ");
		Integer id = sc.nextInt();

		Student studentFound = studentDAO.findById(id);

		System.out.println("What would you like to do with the following student? - " + studentFound.getFirstName());
		System.out.println("Press 1 to change id, 2 for first name, 3 for last and 4 to change email");
		Integer updateChoice = sc.nextInt();

		sc.nextLine();

		if(updateChoice.equals(1)) {
			System.out.println("Enter new id: ");
			Integer newId = sc.nextInt();
			studentFound.setStudId(newId);
			studentDAO.updateStudent(studentFound);
		} else if (updateChoice.equals(2)) {
			System.out.println("Enter new first name: ");
			String newFName = sc.nextLine();
			studentFound.setFirstName(newFName);
			studentDAO.updateStudent(studentFound);
		} else if (updateChoice.equals(3)) {
			System.out.println("Enter new last name: ");
			String newLName = sc.nextLine();
			studentFound.setLastName(newLName);
			studentDAO.updateStudent(studentFound);
		} else {
			System.out.println("Enter new email: ");
			String newEmail = sc.nextLine();
			studentFound.setLastName(newEmail);
			studentDAO.updateStudent(studentFound);
		}


	}


}
