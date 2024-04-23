package com.learn.dbms.dao;
import com.learn.dbms.entity.Student;

import java.util.List;


public interface StudentDAO {
    void save(Student student);

    Student readById(int id);

    List<Student> getAll();

    void updateStudent(Integer id);

    int deleteStudents(String firstName);
}
