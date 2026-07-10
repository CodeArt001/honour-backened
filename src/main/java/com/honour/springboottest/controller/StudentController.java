package com.honour.springboottest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.honour.springboottest.dtos.StudentRequestDto;
import com.honour.springboottest.dtos.StudentResponseDto;
import com.honour.springboottest.entity.Student;
import com.honour.springboottest.service.StudentService;



@RestController
public class StudentController{

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("add-student")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto student){
        int id = studentService.getAllStudent() == null ? 1 : studentService.getAllStudent().size() + 1;
        Student newStudent = new Student(id, student.getName(), student.getLevel());
        studentService.addStudent(newStudent);

        return new StudentResponseDto(id, student.getName(), student.getLevel());
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
        
    }

    // DTOs => Data Transfer Objects

    @PutMapping("students/{id}")
    public String updateStudentById(@PathVariable int id, @RequestBody Student student){
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping("students/{id}")
    public void DeleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
    }


}