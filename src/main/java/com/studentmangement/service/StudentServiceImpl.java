
package com.studentmangement.service;

import com.studentmangement.dao.StudentDao;
import com.studentmangement.exception.StudentNotFoundException;
import com.studentmangement.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public void register(Student student) {
        studentDao.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> displayAll() {
        return studentDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(long id) {

        return studentDao.getById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with ID: " + id
                ));
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.updateById(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentDao.delete(id);
    }
}
