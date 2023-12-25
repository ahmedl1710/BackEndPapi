package com.tn.papibackend.controller;


import com.tn.papibackend.entity.Certification;
import com.tn.papibackend.service.ICertifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.x509.CertificateAlgorithmId;

@RestController
@RequestMapping("/certif")
public class certifController {

    private ICertifService certifService;
    @PostMapping("/addCeritf")
    private ResponseEntity<?> addCertif(@RequestBody Certification certif){
        return certifService.add(certif);  }
    @GetMapping("/retrieveCertif/{id}")
    private ResponseEntity<?> getCertif(@PathVariable Long id)
    {
        return certifService.retrieveById(id);
    }
    @GetMapping("/retrieveCertifs")
    private ResponseEntity<?> getCertifs()
    {
        return certifService.retrieveAll();
    }
    @DeleteMapping("/deleteCertif/{id}")
    private Boolean deleteCertif(@PathVariable Long id)
    {
        return certifService.delete(id);
    }
    @PutMapping("/addcertifWithInterest/{idI}")
    public ResponseEntity<?> addCertifwithInterest(@RequestBody Certification cert,@PathVariable Long idI){
         certifService.affectCertifToInterest(idI,cert.getId());
        return certifService.add(cert);
    }
    @PutMapping("/addcertifWithInterest/{idI}/{idC}")
    public ResponseEntity<?> affectCertifToInterest(@PathVariable Long idC,@PathVariable Long idI){
        return certifService.affectCertifToInterest(idI,idC);
    }

}
