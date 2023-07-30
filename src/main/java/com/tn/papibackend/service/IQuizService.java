package com.tn.papibackend.service;

import com.tn.papibackend.entity.Quizz;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface IQuizService extends IGenericService<Quizz,Long> {

    ResponseEntity<?> updateQuizz(Long id,Quizz q);
}
