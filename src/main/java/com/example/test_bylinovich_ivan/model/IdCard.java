package com.example.test_bylinovich_ivan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;

    @OneToOne
    private Student student;

}
