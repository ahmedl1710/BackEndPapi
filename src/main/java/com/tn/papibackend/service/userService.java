package com.tn.papibackend.service;

import com.tn.papibackend.entity.Role;
import com.tn.papibackend.entity.User;
import org.springframework.http.ResponseEntity;

public interface userService {

    ResponseEntity<?> saveUser(User u);
    ResponseEntity<?> saveRole(Role r);
    ResponseEntity<?> addRoleToUser(String username,String name);
    ResponseEntity<?> getUser(String username);
    ResponseEntity<?> getAllUsers();
    ResponseEntity<?> getAllRoles();
}
