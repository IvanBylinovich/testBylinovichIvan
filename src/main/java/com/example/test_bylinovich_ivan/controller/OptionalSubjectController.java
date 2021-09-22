package com.example.test_bylinovich_ivan.controller;

import com.example.test_bylinovich_ivan.model.IdCard;
import com.example.test_bylinovich_ivan.model.OptionalSubject;
import com.example.test_bylinovich_ivan.model.Student;
import com.example.test_bylinovich_ivan.repository.OptionalSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("optionalSubjects")
public class OptionalSubjectController {
    @Autowired
    OptionalSubjectRepository optionalSubjectRepository;

    @PostMapping()
    public ResponseEntity<?> addOptionalSubject(@RequestBody OptionalSubject optionalSubject){
        try{
            return new ResponseEntity<>(optionalSubjectRepository.save(optionalSubject), HttpStatus.CREATED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateOptionalSubject(@RequestBody OptionalSubject optionalSubject){
        try{
            return new ResponseEntity<>(optionalSubjectRepository.save(optionalSubject), HttpStatus.ACCEPTED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> findOptionalSubjectById(long id){
        Optional<OptionalSubject> optionalSubject = optionalSubjectRepository.findById(id);
        if(optionalSubject.isPresent()){
            return new ResponseEntity<>(optionalSubject.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{subjectId}")
    public ResponseEntity<?> upOptionalSubjectDateById(long subjectId, String name){
        Optional<OptionalSubject> optionalSubject = optionalSubjectRepository.findById(subjectId);

        if(optionalSubject.isPresent()){
            optionalSubject.get().setSubjectName(name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
