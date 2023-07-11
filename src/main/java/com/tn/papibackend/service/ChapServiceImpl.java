package com.tn.papibackend.service;

import com.tn.papibackend.entity.Chapiter;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.chapiterRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ChapServiceImpl extends IGenericServiceImp<Chapiter,Long> implements IChapService{

    private chapiterRepo chaprepo;
}
