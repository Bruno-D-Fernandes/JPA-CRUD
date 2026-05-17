package com.example.CrudDemo.controller;

import com.example.CrudDemo.dao.StudentDAOimpl;
import com.example.CrudDemo.entity.Student;
import com.example.CrudDemo.exceptionHandling.StudentErrorResponse;
import com.example.CrudDemo.exceptionHandling.StundetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get/{studentId}")
    public Student getStudentByID(@PathVariable int studentId){

        Integer teste = studentDAOimpl.getHightId();
        System.out.println(teste);

         if( studentId > teste || studentId < 0) {
            throw new StundetNotFoundException("Estudante fora dos limites");
         }

        return studentDAOimpl.findById(studentId);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentDAOimpl.findAll();
    }



}
