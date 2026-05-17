package com.example.CrudDemo.dao;

import com.example.CrudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    // Create
    void save(Student student);

    // Read
    List<Student> findAll();

    Student findById(int id);

    List<Student> findByLastName(String name);

    Integer getHightId();

    // Update

    void update(Student student);


    // Delete

    void delete(int id);
}
