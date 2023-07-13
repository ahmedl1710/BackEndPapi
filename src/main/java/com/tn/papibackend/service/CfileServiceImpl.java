package com.tn.papibackend.service;


import com.tn.papibackend.entity.Cfile;
import com.tn.papibackend.entity.Chapiter;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.payload.MessageResponse;
import com.tn.papibackend.repository.cfileRepo;
import com.tn.papibackend.repository.chapiterRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@AllArgsConstructor
public class CfileServiceImpl extends IGenericServiceImp<Cfile,Long> implements ICfileService{


    private cfileRepo filerepo;
    private chapiterRepo chaprepo;

    private static final Logger logger = LoggerFactory.getLogger(CfileServiceImpl.class);

    private final Path root = Paths.get("UploadFile");

    @Override
    public MessageResponse uploadFile(List<MultipartFile> files, Long idChap){

        Chapiter chap = chaprepo.findById(idChap).orElse(null);
        logger.debug("RegisterRequest object: {}", chap.toString());
        logger.debug("User object before saving to the database: {}", chap);

        try {
            for (MultipartFile file: files) {
                //Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                Cfile uploadFile = new Cfile();
                uploadFile.setChap(chap);
                uploadFile.setPath(file.getOriginalFilename());
                uploadFile.setFileBlob(file.getBytes());
                filerepo.save(uploadFile);
            }
        }  catch (IOException e) {
            e.printStackTrace();
            return new MessageResponse(false, "Attention", "Upload failed");
        }

        return  new MessageResponse(true, "Success", "Upload succeded");

    }

}


