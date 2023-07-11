package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface interestRepo extends JpaRepository<Interest,Long> {
}
