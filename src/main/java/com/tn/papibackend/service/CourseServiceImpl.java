package com.tn.papibackend.service;

import com.tn.papibackend.entity.Course;
import com.tn.papibackend.generic.IGenericServiceImp;
import com.tn.papibackend.repository.courseRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CourseServiceImpl extends IGenericServiceImp<Course,Long> implements ICourseService {

    private courseRepo courserep;
}
