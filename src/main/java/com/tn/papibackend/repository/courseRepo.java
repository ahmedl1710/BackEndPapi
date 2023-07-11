package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepo  extends JpaRepository<Course,Long> {
}
