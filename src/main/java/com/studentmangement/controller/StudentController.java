
package com.studentmangement.controller;



import com.studentmangement.model.Student;
import com.studentmangement.service.StudentService;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Display registration form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // Save student
    @PostMapping("/save")
    public String saveStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result) {

        if (result.hasErrors()) {
            return "student-form";
        }

        studentService.register(student);

        return "redirect:/student/list";
    }

    // Display all students
    @GetMapping("/list")
    public String getAllStudents(Model model) {

        model.addAttribute(
                "students",
                studentService.displayAll()
        );

        return "student-list";
    }

    // View student details
    @GetMapping("/view/{id}")
    public String viewStudent(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "student",
                studentService.getStudentById(id)
        );

        return "student-details";
    }

    // Display edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "student",
                studentService.getStudentById(id)
        );

        return "student-form";
    }

    // Update student
    @PostMapping("/update")
    public String updateStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result) {

        if (result.hasErrors()) {
            return "student-form";
        }

        studentService.updateStudent(student);

        return "redirect:/student/list";
    }

    // Delete student
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return "redirect:/student/list";
    }
}