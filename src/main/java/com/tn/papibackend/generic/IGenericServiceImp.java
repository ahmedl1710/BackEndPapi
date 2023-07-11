package com.tn.papibackend.generic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class IGenericServiceImp<T,ID> implements IGenericService<T,ID> {



    JpaRepository<T,ID> baseRepository;
    // @Autowired
    //private  BaseRepository<T, ID> baseRepository;

    @Override
    public ResponseEntity<?> add(T entity) {

        try {
             baseRepository.save(entity);
            return  ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving : \n "+ entity);
        }

    }



    @Override
    public ResponseEntity<?> retrieveById(ID id) {

        try {
            T entity =baseRepository.findById(id).orElse(null);
            return  ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while retrieving entity with ID : \n "+ id);
        }
    }

    @Override
    public ResponseEntity<?> retrieveAll() {
        try {
        List<T> list =baseRepository.findAll();
            return  ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while retrieving");
        }
    }

    @Override
    public Boolean delete(ID id) {
        if (baseRepository.existsById(id)) {
            baseRepository.deleteById(id);
            return true;
        }
        else {return false;}
    }
}
