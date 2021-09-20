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
    private long id;
    private String name;
    private String lastName;
    @ManyToOne
    private Group group;
    @ManyToMany
    private Set<OptionalSubject> optionalSubjectSet;
}
