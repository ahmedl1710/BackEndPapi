package com.tn.papibackend.service;

import com.tn.papibackend.entity.Certification;
import com.tn.papibackend.entity.Interest;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.certificationRepo;
import com.tn.papibackend.repository.interestRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CertifServiceImpl extends IGenericServiceImp<Certification,Long> implements ICertifService{

    private certificationRepo certifrepo;
    private interestRepo interestRepo;


    @Override
    public ResponseEntity<?> updateCertif(Long idC, Certification certif) {

        try{
            Certification certifff=certifrepo.findById(idC).orElse(null);
            if(certifff == null) {
                return ResponseEntity.badRequest().body("certification not found");
            }
            certifff.setDatt(certif.getDatt());
            certifff.setInterest(certif.getInterest());
            certifff.setTitle(certif.getTitle());
            certifff.setDescription(certif.getDescription());
            certifrepo.save(certifff);
            return ResponseEntity.ok(certifff);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Eroor updating certification");
        }
    }

    @Override
    public ResponseEntity<?> affectCertifToInterest(Long idI, Long idCertif) {
        try{
            Certification cert =certifrepo.findById(idCertif).orElse(null);
            Interest inter=interestRepo.findById(idI).orElse(null);
            if(cert == null){
                return ResponseEntity.badRequest().body("certification not found");
            }
            if(inter == null){
                return ResponseEntity.badRequest().body("interest not found");
            }
            if(cert.getInterest()==inter){
                return ResponseEntity.badRequest().body("certification already affected to interest");
            }
            inter.getCertifs().add(cert);
            interestRepo.save(inter);
            return ResponseEntity.ok(cert);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error affecting certification to interest");
        }
    }
}
