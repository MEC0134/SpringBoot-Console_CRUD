package com.luv2code.studentmansys.dao;

import com.luv2code.studentmansys.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) { entityManager = theEntityManager; }

    @Override
    @Transactional
    public void createStudent(Student theStudent) { entityManager.persist(theStudent); }

    @Override
    public Student readStudent(Integer id) {
        return null;
    }

    @Override
    public Student updateStudent(Student theStudent) {
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {

    }

}
