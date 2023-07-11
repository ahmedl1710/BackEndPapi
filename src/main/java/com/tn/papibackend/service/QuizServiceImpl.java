package com.tn.papibackend.service;


import com.tn.papibackend.entity.Quizz;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.quizzRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class QuizServiceImpl extends IGenericServiceImp<Quizz,Long> implements IQuizService{
    private quizzRepo quizrepo;
}
