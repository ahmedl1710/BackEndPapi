package com.tn.papibackend.service;

import com.tn.papibackend.entity.Interest;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface IInterestService extends IGenericService<Interest,Long> {

    ResponseEntity<?> updateInyterest(Long id, Interest interest);
    ResponseEntity<?>  supprimerInteret(Long idd);
    ResponseEntity<?>  retrieveInterets();
}
