package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface certificationRepo extends JpaRepository<Certification,Long> {
}
