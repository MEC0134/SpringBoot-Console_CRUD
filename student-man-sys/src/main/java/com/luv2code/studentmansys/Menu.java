package com.luv2code.studentmansys;

import com.luv2code.studentmansys.dao.StudentDAO;
import com.luv2code.studentmansys.entity.Student;

import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);


     void Instructions() {

        System.out.println("*****************************************************************************");
        System.out.println("Welcome to STUDMAN - Your Favorite Student Management Software. " +
                "\nPlease choose carefully from below menu what you would like to do.");
        System.out.println("*****************************************************************************");
    }

     String mainMenuChoice() {
        System.out.println("Please press: \nC - to create new student\nR - to see student information \nU - to update a record for a student" +
                "\nD - to delete a student record using name or id");
        return sc.nextLine();
    }


    // Create
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


    // Read
     void findStudent(StudentDAO studentDAO) {

        System.out.println("Please enter the student id: ");
        Integer id = sc.nextInt();

        Student studentFound = studentDAO.readStudent(id);
        System.out.println(studentFound);
    }


    // Update
     void updateRecord(StudentDAO studentDAO) {

        System.out.println("Please enter the id of the student you want to make changes for: ");
        Integer id = sc.nextInt();

        Student studentFound = studentDAO.findById(id);

        System.out.println("What would you like to do with the following student? - " + studentFound.getFirstName());
        System.out.println("Press 1 to change id, 2 for first name, 3 for last and 4 to change email");
        Integer updateChoice = sc.nextInt();

        sc.nextLine();

        updateRecordChoice(updateChoice, studentFound, studentDAO);

        System.out.println("Student Updated!");
    }


     void updateRecordChoice(Integer updateChoice, Student studentFound, StudentDAO studentDAO) {

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
            studentFound.setEmail(newEmail);
            studentDAO.updateStudent(studentFound);
        }
    }


    // Delete
    public void deleteStudent(StudentDAO studentDAO) {

        System.out.println("Please enter the id of the student you want to delete: ");
        Integer id = sc.nextInt();

        studentDAO.deleteStudent(id);
        System.out.println("Deleting student...");

        System.out.println("Student deleted!");
    }


     int keepGoing() {

        System.out.println("Would you like to do anything else? (Enter 1 for yes, 0 for no)");
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1) {
            return 1;
        } else if(choice == 0) {
            return 0;
        } else {
            System.out.println("Invalid choice. Please enter 0 or 1.");
            return keepGoing();
        }
    }



}
