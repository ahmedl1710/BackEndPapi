package com.tn.papibackend.service;

import com.tn.papibackend.entity.Course;
import com.tn.papibackend.generic.IGenericService;
import org.springframework.http.ResponseEntity;

public interface ICourseService extends IGenericService<Course,Long> {

    ResponseEntity<?> updateCourse(Long id,Course course);
    ResponseEntity<?> affectCourseToInterest(Long idCourse,Long idInt);
    ResponseEntity<?> getCoursesByInterest(String Interest);
    ResponseEntity<?> getTrendCourses();
    ResponseEntity<?> getUserCourses(String username);



}
