package com.tn.papibackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Interest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    Set<User> users;
    @OneToMany(mappedBy = "interest",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Course> courses = new HashSet<>();
    @OneToMany(mappedBy = "interest",cascade = CascadeType.ALL)
    Set<Certification> certifs= new HashSet<>();
}
