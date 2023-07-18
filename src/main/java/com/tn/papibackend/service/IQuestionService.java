package com.tn.papibackend.service;

import com.tn.papibackend.entity.Question;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface IQuestionService extends IGenericService<Question,Long> {

    ResponseEntity<?> updateQuestion(Long id, Question quest);
}
