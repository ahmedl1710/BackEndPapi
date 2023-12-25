package com.tn.papibackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Boolean.TRUE;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    String title;
    Boolean accesslevel = TRUE;
    String description;
    Integer likes;
    Integer dislikes;
    String Price;

    @ManyToOne
    Interest interest;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    Set<Chapiter> chapiters = new HashSet<>();

    @ManyToOne
    User source;

    @ManyToMany
    Set<User> students=new HashSet<>();
}
