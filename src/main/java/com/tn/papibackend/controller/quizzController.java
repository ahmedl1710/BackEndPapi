package com.tn.papibackend.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tn.papibackend.entity.Quizz;
import com.tn.papibackend.service.IQuestionService;
import com.tn.papibackend.service.IQuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizz")
@AllArgsConstructor
public class quizzController {

    private final IQuizService quizzService;


    @PostMapping("/addquizz")
    public ResponseEntity<?> addQuiz(@RequestBody Quizz q)
    {
        return quizzService.add(q);
    }
    @PutMapping("/updateQuizz/{id}")
    public ResponseEntity<?> updateQuizz(@PathVariable Long id,@RequestBody Quizz q)
    {
        return quizzService.updateQuizz(id,q);
    }
    @GetMapping("/getAllQuizz")
    public ResponseEntity<?> getAll()
    {
        return quizzService.retrieveAll();
    }
    @GetMapping("/getQuizz/{id}")
    public ResponseEntity<?> getQuizz(@PathVariable Long id)
    {
        return quizzService.retrieveById(id);
    }
    @DeleteMapping("/delQuizz/{id}")
    public Boolean deleteQuizz(@PathVariable Long id){
        return quizzService.delete(id);
    }
}
