package com.luv2code.studentmansys.dao;

import com.luv2code.studentmansys.entity.Student;

public interface StudentDAO {

    // Create

    void createStudent(Student theStudent);


    // Read

    Student readStudent(Integer id);

    Student findById(Integer id);


    // Update

    void updateStudent(Student theStudent);


    // Read

    void deleteStudent(Integer id);

}
