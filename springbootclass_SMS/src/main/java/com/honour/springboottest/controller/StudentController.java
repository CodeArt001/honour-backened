package com.honour.springboottest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honour.springboottest.entity.Student;
import com.honour.springboottest.service.StudentService;

@RestController
public class StudentController{

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/add-student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
        
    }


}