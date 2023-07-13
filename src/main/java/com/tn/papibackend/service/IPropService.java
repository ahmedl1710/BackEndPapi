package com.tn.papibackend.service;

import com.tn.papibackend.entity.Proposition;
import com.tn.papibackend.entity.Question;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface IPropService extends IGenericService<Proposition,Long> {
    ResponseEntity<?> updateProp(Long id, Proposition prop);

}
