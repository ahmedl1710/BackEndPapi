package com.tn.papibackend.generic;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGenericService<T,ID>  {

    ResponseEntity<?> add(T entity);
    ResponseEntity<?> retrieveById(ID id);
    ResponseEntity<?> retrieveAll();
    Boolean delete(ID id);
}
