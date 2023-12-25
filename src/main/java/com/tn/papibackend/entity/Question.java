package com.tn.papibackend.entity;

import com.sun.istack.NotNull;
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
@FieldDefaults(level =AccessLevel.PRIVATE)
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    @NotNull
    String quest;
    @NotNull
    Long score;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
    Set<Proposition> propositions=new HashSet<>();
    @ManyToOne
    Quizz quizz;
}
