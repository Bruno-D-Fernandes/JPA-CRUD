package com.example.CrudDemo.dao;

import com.example.CrudDemo.entity.Student;



import java.util.List;

public interface StudentDAO {

    void save(Student student);

    List<Student> findAll();

    Student findById(int id);

    Student findByName(String name);


}
