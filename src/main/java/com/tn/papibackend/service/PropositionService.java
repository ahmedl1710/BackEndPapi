package com.tn.papibackend.service;

import com.tn.papibackend.entity.Proposition;
import com.tn.papibackend.entity.Question;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.propositionRepo;
import com.tn.papibackend.repository.questionRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropositionService extends IGenericServiceImp<Proposition,Long> implements IPropService{

    private propositionRepo proprepo;
   private final questionRepo questrep;

    @Override
    public ResponseEntity<?> updateProp(Long id, Proposition prop) {
        try{
            Proposition p = proprepo.findById(id).orElse(null);
            p.setProp(prop.getProp());
            p.setValue(prop.getValue());
            p.setQuestion(prop.getQuestion());
            proprepo.save(p);
            return  ResponseEntity.ok(p);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating proposition");
        }
    }

    @Override
    public ResponseEntity<?> affectPropToQuest(Long idP, Long idQ) {
        try{
            Question q= questrep.findById(idQ).orElse(null);
            Proposition p = proprepo.findById(idP).orElse(null);
            if(q == null){
                return ResponseEntity.badRequest().body("question doesnt exist");
            }
            if( proprepo.findByPropAndQuestionId(p.getProp(),idQ)!= null)
            {
                return ResponseEntity.badRequest().body("propotion already affected to question");
            }
            if(p == null ){
                return ResponseEntity.badRequest().body("proposition doesn t exist");
            }
            q.getPropositions().add(p);
            return ResponseEntity.ok(p);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error affecting proposition to Quizz");
        }
    }


}
