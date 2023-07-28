package com.tn.papibackend.controller;

import com.tn.papibackend.entity.Role;
import com.tn.papibackend.entity.User;
import com.tn.papibackend.service.userService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class userController {
    private final userService userserv;

    @GetMapping("/allusers")
    public ResponseEntity<?> getUsers()
    {
        return userserv.getAllUsers();
    }
    @GetMapping("/allroles")
    public ResponseEntity<?> getRoles()
    {
        return userserv.getAllRoles();
    }
    @PostMapping("/SignUp")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/allusers").toUriString());
         userserv.saveUser(user);
         return ResponseEntity.created(uri).body(user);
    }
    @PostMapping("/saveRole")
    public ResponseEntity<?> saveRole(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/allroles").toUriString());
        userserv.saveRole(role);
        return ResponseEntity.created(uri).body(role);
    }
    @PutMapping("/addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form)
    {
        return userserv.addRoleToUser(form.getUsername(), form.getRolename());
    }
}

@Data
 class RoleToUserForm{
    private String username;
    private String rolename;
}