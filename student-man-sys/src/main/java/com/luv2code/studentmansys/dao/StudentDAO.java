package com.luv2code.studentmansys.dao;

import com.luv2code.studentmansys.entity.Student;

public interface StudentDAO {

    void createStudent(Student theStudent);

    Student readStudent(Integer id);

    Student updateStudent(Student theStudent);

    void deleteStudent(Integer id);

}
