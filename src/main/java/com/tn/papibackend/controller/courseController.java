package com.tn.papibackend.controller;

import com.tn.papibackend.entity.Course;
import com.tn.papibackend.service.IChapService;
import com.tn.papibackend.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class courseController {
    private ICourseService courseService;

    @PostMapping("/addCourse")
    private ResponseEntity<?> addCourse(@RequestBody Course course)
    {
        return courseService.add(course);
    }
    @PutMapping("/updateCourse/{id}")
    private ResponseEntity<?> updateCourse(@RequestBody Course course,@PathVariable Long id)
    {
        return courseService.updateCourse(id,course);
    }
    @GetMapping("/getCourse/{id}")
    private ResponseEntity<?> getCourse(@PathVariable Long id)
    {
        return courseService.retrieveById(id);
    }
    @GetMapping("/getAllCourses")
    private ResponseEntity<?> getAllCourses()
    {
        return courseService.retrieveAll();
    }
    @DeleteMapping("/deleteCourse/{id}")
    private Boolean deleteCourse(@PathVariable Long id)
    {
        return courseService.delete(id);
    }
    @PutMapping("/affectCourseInterest/{idCourse}/{idInterest}")
    private ResponseEntity<?> affectCourseToInterest(@PathVariable Long idCourse,@PathVariable Long idInterest)
    {
        return courseService.affectCourseToInterest(idCourse,idInterest);
    }
    @GetMapping("/getCoursesInt/{interest}")
    public ResponseEntity<?> getCoursesByInt(@PathVariable String interest){
        return courseService.getCoursesByInterest(interest);
    }
    @GetMapping("/getCoursesTrend")
    public ResponseEntity<?> getCoursesTrend(){
        return courseService.getTrendCourses();
    }
}
