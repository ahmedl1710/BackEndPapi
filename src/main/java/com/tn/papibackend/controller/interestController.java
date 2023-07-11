package com.tn.papibackend.controller;


import com.tn.papibackend.entity.Interest;
import com.tn.papibackend.service.IInterestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
