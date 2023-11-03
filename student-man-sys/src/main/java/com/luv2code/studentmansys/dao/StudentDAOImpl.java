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
        Student theStudent = entityManager.find(Student.class, id);
        return theStudent;
    }

    @Override
    public Student findById(Integer id) { return entityManager.find(Student.class, id); }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) { entityManager.merge(theStudent); }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student studentFound = entityManager.find(Student.class, id);
        entityManager.remove(studentFound);
    }

}
