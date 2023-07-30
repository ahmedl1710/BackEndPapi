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
    public ResponseEntity<?> addProp(@RequestBody Proposition prop)
    {
        return propService.add(prop);
    }

    @PostMapping("/addProp/{idQ}")
    public ResponseEntity<?> addPropwithQuest(@RequestBody Proposition prop,@PathVariable Long idQ)
    {
        propService.affectPropToQuest(prop.getId(),idQ);
        return propService.add(prop);
    }
    @PutMapping("/affectPropToQuest/{idQ}/{idP}")
    public ResponseEntity<?> affectPropToQuest(@PathVariable Long idQ,@PathVariable Long idP){
        return propService.affectPropToQuest(idP,idQ);
    }
    @PutMapping("/updateProp/{id}")
    public ResponseEntity<?> updateProp(@PathVariable Long id,@RequestBody Proposition prop)
    {
        return propService.updateProp(id,prop);
    }

    @GetMapping("/getProp/{id}")
    public ResponseEntity<?> getProp(@PathVariable Long id)
    {
        return propService.retrieveById(id);
    }

    @GetMapping("/getProps")
    public ResponseEntity<?> getProps()
    {
        return propService.retrieveAll();
    }

    @DeleteMapping("/delProp/{id}")
    public Boolean delProp(@PathVariable Long id)
    {
        return propService.delete(id);
    }

}
