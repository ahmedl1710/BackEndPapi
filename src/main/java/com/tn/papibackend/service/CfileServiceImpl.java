package com.tn.papibackend.service;


import com.tn.papibackend.entity.Cfile;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.cfileRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CfileServiceImpl extends IGenericServiceImp<Cfile,Long> implements ICfileService{


    private cfileRepo filerepo;

}
