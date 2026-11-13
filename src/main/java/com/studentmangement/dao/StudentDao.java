package com.studentmangement.dao;

import com.studentmangement.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDao {
    @PersistenceContext
    private EntityManager entityManager;


    //save
    public void save(Student student){
        entityManager.persist(student);
    }

    //get student record by id
    public Optional<Student> getById(long id){
        return Optional.ofNullable(entityManager.find(Student.class,id));
    }

    // get all student record

    public List<Student> getAll(){
        return entityManager.createQuery(" select s from Student s", Student.class)
                .getResultList();

    }


    //update student record
    public void updateById(Student student){
    entityManager.merge(student);

    }
    //delete student record by id

    public void delete(Long id){
        Student student = entityManager.find(Student.class, id);
        if (student != null){
            entityManager.remove(student);
        }
    }

}
