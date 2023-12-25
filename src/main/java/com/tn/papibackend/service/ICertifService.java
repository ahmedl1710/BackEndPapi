package com.tn.papibackend.service;

import com.tn.papibackend.entity.Certification;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface ICertifService extends IGenericService<Certification,Long> {
    ResponseEntity<?> updateCertif(Long idC,Certification certif);
    ResponseEntity<?> affectCertifToInterest(Long idI,Long idCertif);
}
