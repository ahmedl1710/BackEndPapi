package com.tn.papibackend.controller;


import com.tn.papibackend.entity.Question;
import com.tn.papibackend.service.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class questionController {

    private IQuestionService questionService;

    @PostMapping("/addQuestion")
    public ResponseEntity<?> addQuest(@RequestBody Question quest){
        return questionService.add(quest);
    }
    @PostMapping("/addQuestion/{idQuizz}")
    public ResponseEntity<?> addQuestwithQuizz(@RequestBody Question quest,@PathVariable Long idQuizz){
        questionService.affectQuestionToQuizz(quest.getId(),idQuizz);
        return questionService.add(quest);
    }
    @PutMapping("/updateQuestion/{id}")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question,@PathVariable Long id)
    {
        return questionService.updateQuestion(id,question);
    }
    @PutMapping("/affectQuestQuizz/{idques}/{idQuizz}")
    public ResponseEntity<?> affectQuestQuizz(@PathVariable Long idQuest,@PathVariable Long idQuizz)
    {
        return questionService.affectQuestionToQuizz(idQuest, idQuizz);
    }
    @GetMapping("/getQuestion/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable Long id){
        return questionService.retrieveById(id);
    }
    @GetMapping("/getAllQuestions")
    public ResponseEntity<?> getQuestions()
    {
        return questionService.retrieveAll();
    }
    @DeleteMapping("/delQuest/{id}")
    public Boolean deleteQuestion(@PathVariable Long id)
    {
        return questionService.delete(id);
    }


}
