package com.tn.papibackend.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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
    Date naissance;
    Role role;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    Set<Quizz> quizzes =new HashSet<>();
    @ManyToMany
    Set<Interest> interests = new HashSet<>();

}
