package com.iuh.student.controller;

import com.iuh.student.enity.Student;
import com.iuh.student.service.StudentService;
import com.iuh.student.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getStudentWithFaculty(@PathVariable("id") Long studentId){
        return studentService.getUserWithFaculties(studentId);
    }
}
