package com.tn.papibackend.service;


import com.tn.papibackend.entity.Interest;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.interestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class InterestServiceImpl extends IGenericServiceImp<Interest,Long> implements IInterestService{


    private interestRepo interestrepo;
}
