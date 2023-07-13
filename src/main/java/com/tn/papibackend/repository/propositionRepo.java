package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface propositionRepo extends JpaRepository<Proposition,Long> {
}
