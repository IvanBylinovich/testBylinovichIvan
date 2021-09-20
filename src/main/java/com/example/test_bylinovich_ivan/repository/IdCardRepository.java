package com.example.test_bylinovich_ivan.repository;

import com.example.test_bylinovich_ivan.model.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdCardRepository extends JpaRepository<IdCard, Long> {
}
