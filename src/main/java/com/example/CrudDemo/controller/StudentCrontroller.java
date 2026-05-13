package com.example.CrudDemo.controller;

import com.example.CrudDemo.dao.StudentDAOimpl;
import com.example.CrudDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudante")
public class StudentCrontroller {

    StudentDAOimpl studentDAOimpl;

    @Autowired
    StudentCrontroller(StudentDAOimpl studentDAOimpl){ this.studentDAOimpl = studentDAOimpl; }

    @PostMapping("/create")
    public Student saveStudent(@RequestBody Student student){
        studentDAOimpl.save(student);

        return student;
    }

    @GetMapping("getAll")
    public List<Student> getAll(){
        return studentDAOimpl.findAll();
    }

}
