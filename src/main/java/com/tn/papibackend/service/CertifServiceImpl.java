package com.tn.papibackend.service;

import com.tn.papibackend.entity.Certification;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.certificationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CertifServiceImpl extends IGenericServiceImp<Certification,Long> implements ICertifService{

    private certificationRepo certifrepo;


}
