package com.honour.springboottest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.honour.springboottest.entity.Student;
import com.honour.springboottest.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;

    }

    public void addStudent(Student student){
        if (student.getId() < 1) {
            throw new RuntimeException("Id that are less than 1 are not permitted");
        }

        studentRepository.addStudent(student);
    }

    public List<Student> getAllStudent(){
        
        return studentRepository.getAllStudents();
    }
    
    public Student getStudentById(int id){
        if (studentRepository.getStudentById(id) == null){
        throw new RuntimeException("Student with id " + id + " is not found");
    }

    return studentRepository.getStudentById(id);
    }

    public String updateStudentById(int id, Student student){
        Student existingStudent = studentRepository.getStudentById(id);
        if (existingStudent == null) {
            throw new RuntimeException("Student with id " + id + " is not found");
            
        }

        existingStudent.setId(student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setLevel(student.getLevel());


        return "Updated Student Succesfully";

    }

    public void deleteStudentById(int id){
        studentRepository.deleteStudentById(id);
    }
}
