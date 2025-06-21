package com.example.Course.Registration.System.Service;

import com.example.Course.Registration.System.Model.Course;
import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Repository.Courseregistryrepo;
import com.example.Course.Registration.System.Repository.Courserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Courseservice {

    @Autowired
    Courserepo courserepo;
    @Autowired
    Courseregistryrepo courseregistryrepo;

    public List<Course> availablecourses() {
        return courserepo.findAll();
    }

    public List<CourseRegistry> enrolledstudents() {
        return courseregistryrepo.findAll();
    }

    public void enrollcourse(String name, String emailid, String courseName) {
        CourseRegistry courseRegistry=new CourseRegistry(name,emailid,courseName);
        courseregistryrepo.save(courseRegistry);
    }
}
