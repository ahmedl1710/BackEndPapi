package com.tn.papibackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    String name;
    String email;
    String password;
    Long phone;
    LocalDate naissance;
    String username;


    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    Set<Quizz> quizzes =new HashSet<>();

    @ManyToMany(mappedBy="users", cascade = CascadeType.ALL)
    Set<Interest> interests = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    Set<Course> courses = new HashSet<>();


}
