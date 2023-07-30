package com.tn.papibackend.service;


import com.tn.papibackend.entity.Question;
import com.tn.papibackend.entity.Quizz;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.quizzRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class QuizServiceImpl extends IGenericServiceImp<Quizz,Long> implements IQuizService{
    private quizzRepo quizrepo;

    @Override
    public ResponseEntity<?> updateQuizz(Long id, Quizz q) {
        Quizz qq=quizrepo.findById(id).orElse(null  );
        try{
            if(qq == null){
                return ResponseEntity.badRequest().body("interest doesn t exists");
            }
            qq.setDescription(q.getDescription());
            qq.setName(q.getName());
            qq.setNote(q.getNote());
            qq.setQuestions(q.getQuestions());
            quizrepo.save(qq);
            return  ResponseEntity.ok(qq);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating quizz");
        }
    }
}
