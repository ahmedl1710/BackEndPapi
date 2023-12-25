package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface questionRepo extends JpaRepository<Question,Long> {

    Question findByQuest(String text);
}
