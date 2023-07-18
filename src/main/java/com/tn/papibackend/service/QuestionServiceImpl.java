package com.tn.papibackend.service;

import com.tn.papibackend.entity.Question;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.questionRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class QuestionServiceImpl extends IGenericServiceImp<Question,Long> implements IQuestionService{

    private questionRepo questrepo;

        @Override
    public ResponseEntity<?> updateQuestion(Long id, Question quest) {
        try{
            if(questrepo.findByQuest(quest.getQuest()) != null){
                return ResponseEntity.badRequest().body("interest already exists");
            }
           Question q= questrepo.findById(id).orElse(null);
            q.setQuest(quest.getQuest());
            q.setQuizz(quest.getQuizz());
            q.setPropositions(quest.getPropositions());
            q.setScore(quest.getScore());
            questrepo.save(q);
            return  ResponseEntity.ok(q);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating question");
        }
    }
}
