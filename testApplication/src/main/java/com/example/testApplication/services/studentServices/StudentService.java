package com.example.testApplication.services.studentServices;

import com.example.testApplication.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student addNewStudent(Student student);
    Student changeStudent(String name, Student student);
    void deleteStudent(String name);

}
