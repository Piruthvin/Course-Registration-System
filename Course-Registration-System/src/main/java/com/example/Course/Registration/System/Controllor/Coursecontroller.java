package com.example.Course.Registration.System.Controllor;

import com.example.Course.Registration.System.Model.Course;
import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class Coursecontroller {

    @Autowired
    Courseservice courseservice;
    @GetMapping("/courses")
    public List<Course> availablercourse(){
        return courseservice.availablecourses();
    }


    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseservice.enrolledstudents();
    }

    @PostMapping("/courses/register")
    public String enrollstudents(@RequestParam("name") String name,
                                 @RequestParam("emailid") String emailid,
                                 @RequestParam("courseName") String courseName){
        courseservice.enrollcourse(name,emailid,courseName);
        return "Congratulations ! "+name+"Your Enrolled Sucessfully for "+courseName;
    }

    @GetMapping("/")
    public String home(){
        return "Home-Page";
    }
}
