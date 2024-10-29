package com.example.testApplication.controllers;

import com.example.testApplication.entities.Student;
import com.example.testApplication.services.studentServices.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(path = "allStudents")
    public List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList = studentService.getAllStudents();

        return studentList;
    }

    @PostMapping(path = "addNewStudent")
    public ResponseEntity<String> createNewStudent(@RequestBody Student student){

        Student saved = studentService.addNewStudent(student);

        return new ResponseEntity<>("new student "+saved.getName()+" "+saved.getSurname()+" was added!", HttpStatus.CREATED);
    }

    @PatchMapping(path = "alterStudent/{name}")
    public ResponseEntity<Student> alterStudent(@PathVariable String name,
                                                @RequestBody Student student){
        Student changed = studentService.changeStudent(name, student);

        return new ResponseEntity<>(changed, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "deleteStudent/{name}")
    public ResponseEntity<String> deleteStudent(@PathVariable String name){
        studentService.deleteStudent(name);

        return new ResponseEntity<>("student "+name+" was delete!", HttpStatus.NO_CONTENT);

    }
}
