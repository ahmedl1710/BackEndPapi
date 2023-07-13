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
    private ResponseEntity<?> addQuest(@RequestBody Question quest){
        return questionService.add(quest);
    }
    @PutMapping("/updateQuestion/{id}")
    private ResponseEntity<?> updateQuestion(@RequestBody Question question,@PathVariable Long id)
    {
        return questionService.updateQuestion(id,question);
    }
    @GetMapping("/getQuestion/{id}")
    private ResponseEntity<?> getQuestion(@PathVariable Long id){
        return questionService.retrieveById(id);
    }
    @GetMapping("/getAllQuestions")
    private ResponseEntity<?> getQuestions()
    {
        return questionService.retrieveAll();
    }
    @DeleteMapping("/delQuest/{id}")
    private Boolean deleteQuestion(@PathVariable Long id)
    {
        return questionService.delete(id);
    }


}
