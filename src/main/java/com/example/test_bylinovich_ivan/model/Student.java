package com.example.test_bylinovich_ivan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    @ManyToOne
    private GroupUni groupUni;
    @ManyToMany
    private Set<OptionalSubject> optionalSubject;
}
