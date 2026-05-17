package com.example.CrudDemo.dao;

import com.example.CrudDemo.entity.Student;
import com.example.CrudDemo.exceptionHandling.StudentErrorResponse;
import com.example.CrudDemo.exceptionHandling.StundetNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


@Repository
public class StudentDAOimpl implements StudentDAO {

    private EntityManager entityManager;

    // Não é necessário, já que, temos somente um construtor
    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // o que exatamente isso faz?
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :name", Student.class);
        query.setParameter("name", lastName);


        return query.getResultList();
    }

    @Override
    public Integer getHightId() {
        TypedQuery<Integer> query = entityManager.createQuery("SELECT MAX(id) FROM Student", Integer.class);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    // o que esse Transactional faz?
    @Transactional
    public void delete(int id) {
        Student student = this.findById(id);
        Query query = entityManager.createQuery("DELETE FROM Student WHERE id = :id");
        query.setParameter("id", id);

        int rolls = query.executeUpdate();
        System.out.println("Deleted student with id " + id + " with rolls " + rolls);
    }

}
