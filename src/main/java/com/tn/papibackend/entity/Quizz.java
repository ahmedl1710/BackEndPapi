package com.tn.papibackend.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quizz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    String name;
    String description;
    Long note;

    @ManyToOne
    User user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "quizz")
    Set<Question> questions = new HashSet<>();
;
}
