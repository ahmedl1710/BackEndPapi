package com.tn.papibackend.service;

import com.tn.papibackend.entity.Chapiter;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface IChapService extends IGenericService<Chapiter,Long> {

    ResponseEntity<?> updateChapiter(Long id,Chapiter chap);
    ResponseEntity<?> affectCChapToCourse(Long idChap,Long IdCourse);

}
