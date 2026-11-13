package com.studentmangement.service;

import com.studentmangement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void register(Student student);
    List<Student> displayAll();
    Student getStudentById(long id);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
