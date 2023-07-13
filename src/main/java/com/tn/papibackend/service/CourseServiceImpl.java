package com.tn.papibackend.service;

import com.tn.papibackend.entity.Course;
import com.tn.papibackend.entity.Question;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.courseRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CourseServiceImpl extends IGenericServiceImp<Course,Long> implements ICourseService {

    private courseRepo courserep;

    @Override
    public ResponseEntity<?> updateCourse(Long id, Course course) {
        try{
            if(courserep.findByTitle(course.getTitle()) != null){
                return ResponseEntity.badRequest().body("title already exists");
            }
            Course cor=courserep.findById(id).orElse(null);
            cor.setTitle(course.getTitle());
            cor.setAccesslevel(course.getAccesslevel());
            cor.setChapiters(course.getChapiters());
            cor.setSource(course.getSource());
            cor.setInterest(course.getInterest());
            courserep.save(cor);
            return  ResponseEntity.ok(cor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating course");
        }
    }
    }

