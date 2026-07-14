package com.honour.springboottest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.honour.springboottest.entity.Student;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentById(int id){
        return students.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow();
    }
}
