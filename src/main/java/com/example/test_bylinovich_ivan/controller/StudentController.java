package com.example.test_bylinovich_ivan.controller;

import com.example.test_bylinovich_ivan.model.GroupUni;
import com.example.test_bylinovich_ivan.model.OptionalSubject;
import com.example.test_bylinovich_ivan.model.Student;
import com.example.test_bylinovich_ivan.repository.OptionalSubjectRepository;
import com.example.test_bylinovich_ivan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping()
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentRepository.save(student), HttpStatus.ACCEPTED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> findStudentById(long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{subjectId}")
    public ResponseEntity<?> upStudentDateById(long studentId, String name, String lastName, GroupUni groupUni){
        Optional<Student> student = studentRepository.findById(studentId);

        if(student.isPresent()){
            student.get().setName(name);
            student.get().setLastName(lastName);
            student.get().setGroupUni(groupUni);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
