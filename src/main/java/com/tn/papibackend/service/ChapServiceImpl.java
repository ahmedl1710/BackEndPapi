package com.tn.papibackend.service;

import com.tn.papibackend.entity.Chapiter;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.chapiterRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ChapServiceImpl extends IGenericServiceImp<Chapiter,Long> implements IChapService{


    private chapiterRepo chaprepo;

    @Override
    public ResponseEntity<?> updateChapiter(Long id,Chapiter chap) {
        Chapiter chapiter = chaprepo.findById(id).orElse(null);
        try {
            if (chaprepo.findByTitleAndCourseId(chap.getTitle(),chapiter.getCourse().getId()) != null) {
                return ResponseEntity.badRequest().body("chapiter already exists");
            }
            chapiter.setTitle(chap.getTitle());
            chapiter.setCourse(chap.getCourse());
            chapiter.setFiles(chap.getFiles());
            chapiter.setDatt(chap.getDatt());
            chaprepo.save(chapiter);
            return ResponseEntity.ok(chapiter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating question");
        }
    }
}
