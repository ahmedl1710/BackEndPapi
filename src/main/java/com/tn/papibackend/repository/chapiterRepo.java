package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Chapiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface chapiterRepo extends JpaRepository<Chapiter,Long> {

    Chapiter findByTitleAndCourseId(String tit,Long id);

}
