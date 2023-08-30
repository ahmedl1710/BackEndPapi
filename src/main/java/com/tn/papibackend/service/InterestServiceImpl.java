package com.tn.papibackend.service;


import com.tn.papibackend.entity.Interest;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.interestRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class InterestServiceImpl extends IGenericServiceImp<Interest,Long> implements IInterestService {


    private interestRepo interestrepo;

    @Override
    public ResponseEntity<?> updateInyterest(Long id, Interest interest) {
       /* try{
            if(interestrepo.findByName(interest.getName()) != null){
                return ResponseEntity.badRequest().body("interest already exists");
            }
            Interest inte=interestrepo.findById(id).orElse(null);
            inte.setCourses(interest.getCourses());
            inte.setName(interest.getName());
            inte.setUsers(interest.getUsers());
            interestrepo.save(inte);
            return  ResponseEntity.ok(inte);
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating interest");
    }*/
        return null;
    }

    @Override
    public ResponseEntity<?> supprimerInteret(Long id) {
        try {
            Interest interet = interestrepo.findById(id).orElse(null);
            interestrepo.delete(interet);
            return ResponseEntity.ok(interet + "deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting interest");
        }
    }

    @Override
    public ResponseEntity<?> retrieveInterets() {
        try {
            List<Interest> interets = interestrepo.findAll();
            for (Interest interest : interets) {
                // Calculate the length of users set
                interest.setUsersLength(interest.getUsers() != null ? interest.getUsers().size() : 0);

                // Calculate the length of courses set
                interest.setCoursesLength(interest.getCourses() != null ? interest.getCourses().size() : 0);

                // Calculate the length of certifs set
                interest.setCertifsLength(interest.getCertifs() != null ? interest.getCertifs().size() : 0);
            }
            return ResponseEntity.ok(interets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting interest");
        }
    }
}
