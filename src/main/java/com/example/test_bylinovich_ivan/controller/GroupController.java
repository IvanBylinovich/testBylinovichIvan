package com.example.test_bylinovich_ivan.controller;

import com.example.test_bylinovich_ivan.model.Group;
import com.example.test_bylinovich_ivan.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("groups")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @PostMapping()
    public ResponseEntity<?> addGroup(@RequestBody Group group){
        try{
            return new ResponseEntity<>(groupRepository.save(group), HttpStatus.CREATED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateGroup(@RequestBody Group group){
        try{
            return new ResponseEntity<>(groupRepository.save(group), HttpStatus.ACCEPTED);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> findGroupById(long id){
        Optional<Group> pet = groupRepository.findById(id);
        if(pet.isPresent()){
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{groupId}")
    public ResponseEntity<?> upGroupDateById(long groupId, String name){
        Optional<Group> group = groupRepository.findById(groupId);

        if(group.isPresent()){
            group.get().setName(name);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
