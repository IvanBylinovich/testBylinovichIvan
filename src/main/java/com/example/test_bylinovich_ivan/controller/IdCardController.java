package com.example.test_bylinovich_ivan.controller;

import com.example.test_bylinovich_ivan.model.IdCard;
import com.example.test_bylinovich_ivan.model.Student;
import com.example.test_bylinovich_ivan.repository.IdCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("IdCards")
public class IdCardController {

    @Autowired
    IdCardRepository idCardRepository;

    @PostMapping()
    public ResponseEntity<?> addIdCard(@RequestBody IdCard idCard){
        try{
            return new ResponseEntity<>(idCardRepository.save(idCard), HttpStatus.CREATED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateIdCard(@RequestBody IdCard idCard){
        try{
            return new ResponseEntity<>(idCardRepository.save(idCard), HttpStatus.ACCEPTED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> findIdCardById(long id){
        Optional<IdCard> idCard = idCardRepository.findById(id);
        if(idCard.isPresent()){
            return new ResponseEntity<>(idCard.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{number}")
    public ResponseEntity<?> upIdCardDateById(long number, Student student){
        Optional<IdCard> idCard = idCardRepository.findById(number);

        if(idCard.isPresent()){
            idCard.get().setStudent(student);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
