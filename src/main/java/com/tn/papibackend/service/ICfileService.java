package com.tn.papibackend.service;

import com.tn.papibackend.entity.Cfile;
import com.tn.papibackend.generic.IGenericService;
import com.tn.papibackend.filter.payload.MessageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ICfileService extends IGenericService<Cfile,Long> {

      MessageResponse uploadFile(List<MultipartFile> files, Long idChap);




     }
