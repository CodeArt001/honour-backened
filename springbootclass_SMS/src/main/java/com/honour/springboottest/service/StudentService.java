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
        if (studentRepository.getAllStudents().isEmpty()){
            throw new RuntimeException("No student yet");
        }
        
        return studentRepository.getAllStudents();
    }
    
    public Student getStudentById(int id){
        if (studentRepository.getStudentById(id) == null){
        throw new RuntimeException("Student with id " + id + " is not found");
    }

    return studentRepository.getStudentById(id);



    }
}
