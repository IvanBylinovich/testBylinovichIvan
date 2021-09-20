package com.example.test_bylinovich_ivan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OptionalSubject {
    @Id
    private long id;
    private String subjectName;
}
