package com.learn.dbms.dao;

import com.learn.dbms.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements  StudentDAO{
    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student readById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> createQuery = entityManager.createQuery("FROM Student", Student.class);
        return createQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Integer id) {
        Student student = entityManager.find(Student.class, id);
        System.out.println("Current student is " + student);
        student.setFirstName("Scooby");
         entityManager.merge(student);
    }

    @Override
    @Transactional
    public int deleteStudents(String firstName) {
        Query query = entityManager.createQuery("DELETE FROM Student WHERE firstName = :data");
        query.setParameter("data", firstName);
        return query.executeUpdate();
    }
}
