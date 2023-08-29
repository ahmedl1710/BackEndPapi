package com.tn.papibackend.service;

import com.tn.papibackend.entity.Role;
import com.tn.papibackend.entity.User;
import com.tn.papibackend.repository.roleRepo;
import com.tn.papibackend.repository.userRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.text.resources.zh.CollationData_zh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@AllArgsConstructor
public class UserServiiceImpl implements userService, UserDetailsService {

    final userRepo userrep;
    final roleRepo rolerep;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrep.findByUsername(username);
        if(user ==null)
        {
            throw new UsernameNotFoundException("User not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach( role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        } );
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
    @Override
    public ResponseEntity<?> saveUser(User u) {
        try{
            if(userrep.findByUsername(u.getUsername()) != null){
                return ResponseEntity.badRequest().body("username already token");
            }
            u.setPassword(passwordEncoder.encode(u.getPassword()));
            userrep.save(u);
            return  ResponseEntity.created(null).body(u);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user");
        }
    }

    @Override
    public ResponseEntity<?> saveRole(Role r) {
        try {
            if (rolerep.findByName(r.getName()) != null) {
                return ResponseEntity.badRequest().body("Role already exist");
            }
            rolerep.save(r);
            return ResponseEntity.created(null).body(r);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving role");
        }
    }

    @Override
    public ResponseEntity<?> addRoleToUser(String username, String name) {
        try{
            Role r=rolerep.findByName(name);
            User u=userrep.findByUsername(username);
            if(r == null ){
                return ResponseEntity.badRequest().body("Role doesn t exist");
            }if( u == null ){
                return ResponseEntity.badRequest().body("USer doesn t exist");
            }
            u.getRoles().add(r);
            userrep.save(u);
            return  ResponseEntity.ok(r);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding role to user");
        }
    }

    @Override
    public ResponseEntity<?> getUser(String username) {
        try {
            User u=userrep.findByUsername(username);
            if(u == null ){
                return ResponseEntity.badRequest().body("user doesn t exist");
            }
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retreving user");
        }
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        try {
           List<User> users=userrep.findAll();
            if(users == null ){
                return ResponseEntity.badRequest().body("table is empty !!!!!!");
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retreving users");
        }
    }
    @Override
    public ResponseEntity<?> getAllRoles() {
        try {
            List<Role> roles=rolerep.findAll();
            if(roles == null ){
                return ResponseEntity.badRequest().body("table is empty !!!!!!");
            }
            return ResponseEntity.ok(roles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retreving roles");
        }
    }

    @Override
    public ResponseEntity<?> getUserUsername(String username) {
        try {
            User u = userrep.findByUsername(username);
            if(u == null ){
                return ResponseEntity.badRequest().body("user does not exist!!!!!!");
            }
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retreving user");
        }
    }
    @Override
    public ResponseEntity<?> supprimerUser(Long id) {
        try {
            User us = userrep.findById(id).orElse(null);
            userrep.delete(us);
            return ResponseEntity.ok(us + "deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }


}
