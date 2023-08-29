package com.tn.papibackend.controller;


import com.tn.papibackend.entity.Interest;
import com.tn.papibackend.service.IInterestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/interest")
public class interestController {

    private IInterestService interestService;

    @PostMapping("/addInterest")
    private ResponseEntity<?> saveInterest(@RequestBody Interest interest)
    {
            return  interestService.add(interest);
    }
    @PutMapping("/updateInterest/{id}")
    private ResponseEntity<?> updateInterest(@RequestBody Interest interest, @PathVariable Long id)
    {
        return interestService.updateInyterest(id, interest);
    }
    @GetMapping("/retrieveInterest/{id}")
    private ResponseEntity<?> retrieveinterest(@PathVariable Long id)
    {
        return interestService.retrieveById(id);
    }
    @GetMapping("/retrieveInterests")
    private ResponseEntity<?> retieveAllInterests(){
        return interestService.retrieveAll();
    }
    @DeleteMapping("/delInterest/{id}")
    private ResponseEntity<?>  delinterest(@PathVariable Long id)
    {
        return interestService.supprimerInteret(id);
    }
}
