package com.example.testApplication.services.studentServices;

import com.example.testApplication.exception.StudentDoesNotExistException;
import com.example.testApplication.entities.Student;
import com.example.testApplication.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        List<Student> list = studentRepository.findAll();
        if (list.isEmpty()){
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public Student addNewStudent(Student student) {

        Student newby = new Student();

        newby.setId(student.getId());
        newby.setName(student.getName());
        newby.setSurname(student.getSurname());
        newby.setPatronymic(student.getPatronymic());
        newby.setGroup(student.getGroup());
        newby.setRate(student.getRate());

        return studentRepository.save(newby);
    }

    @Override
    public Student changeStudent(String name, Student student) {
        Optional<Student> checkIfExist = studentRepository.findByNameIgnoreCase(name);
        if (checkIfExist.isEmpty()){
            throw new StudentDoesNotExistException();
        }
        Student really = checkIfExist.get();

        if (student.getName() != null){
            really.setName(student.getName());
        }if (student.getSurname() != null){
            really.setSurname(student.getSurname());
        }if (student.getPatronymic() != null){
            really.setPatronymic(student.getPatronymic());
        }if (student.getGroup() != null){
            really.setGroup(student.getGroup());
        }

        studentRepository.save(really);

        return really;
    }


    @Override
    public void deleteStudent(String name) {
        Optional<Student> checkIfExist = studentRepository.findByNameIgnoreCase(name);
        if (checkIfExist.isEmpty()){
            throw new StudentDoesNotExistException();
        }
        studentRepository.delete(checkIfExist.get());

    }
}
