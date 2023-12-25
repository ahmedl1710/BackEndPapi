package com.tn.papibackend.controller;

import com.tn.papibackend.entity.Chapiter;
import com.tn.papibackend.service.IChapService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/chapiter")
public class chapiterController {

    private IChapService chapService;

    @PostMapping("/addChap")
    private ResponseEntity<?> addChap(@RequestBody Chapiter chap)
    {
        return chapService.add(chap);
    }
    @PutMapping("/updateChap/{id}")
    private ResponseEntity<?> updateChap(@PathVariable Long id,@RequestBody Chapiter chap)
    {
        return chapService.updateChapiter(id,chap);
    }
    @GetMapping("/getChapiter/{id}")
    private ResponseEntity<?> getChapiter(@PathVariable Long id){
        return chapService.retrieveById(id);
    }
    @GetMapping("/getChapiters")
    private ResponseEntity<?> getAllChapiters(){
        return chapService.retrieveAll();
    }
    @DeleteMapping("/deleteChap/{id}")
    private Boolean deleteChap(@PathVariable Long id)
    {
        return chapService.delete(id);
    }

    @PutMapping("/affectChap/{idChap}/{idCourse}")
    private ResponseEntity<?> affectChapToCourse(@PathVariable Long idChap,@PathVariable Long idCourse)
    {
        return chapService.affectCChapToCourse(idChap,idCourse);
    }
    @PostMapping("/addChap/{idCourse}")
    private ResponseEntity<?> addChapwithCourse(@RequestBody Chapiter chap,@PathVariable Long idCourse)
    {
        return chapService.add(chap);
    }
}
