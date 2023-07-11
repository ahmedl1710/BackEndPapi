package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface quizzRepo extends JpaRepository<Quizz,Long> {
}
