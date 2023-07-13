package com.tn.papibackend.controller;

import com.tn.papibackend.entity.Proposition;
import com.tn.papibackend.service.IPropService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
 @RequestMapping("/proposition")
public class propositionController {

    private IPropService propService;

    @PostMapping("/addProp")
    private ResponseEntity<?> addProp(@RequestBody Proposition prop)
    {
        return propService.add(prop);
    }

    @PutMapping("/updateProp/{id}")
    private ResponseEntity<?> updateProp(@PathVariable Long id,@RequestBody Proposition prop)
    {
        return propService.updateProp(id,prop);
    }

    @GetMapping("/getProp/{id}")
    private ResponseEntity<?> getProp(@PathVariable Long id)
    {
        return propService.retrieveById(id);
    }

    @GetMapping("/getProps")
    private ResponseEntity<?> getProps()
    {
        return propService.retrieveAll();
    }

    @DeleteMapping("/delProp/{id}")
    private Boolean delProp(@PathVariable Long id)
    {
        return propService.delete(id);
    }

}
