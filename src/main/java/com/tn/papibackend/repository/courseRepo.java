package com.tn.papibackend.repository;

import com.tn.papibackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface courseRepo  extends JpaRepository<Course,Long> {

    Course findByTitle(String title);
    Set<Course> findByInterestName(String interest);
    Set<Course> findTop3ByOrderByLikesDesc();
}
