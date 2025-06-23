package com.example.Course.Registration.System.Controllor;

import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Model.Users;
import com.example.Course.Registration.System.Service.Courseservice;
import com.example.Course.Registration.System.Service.adduserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    Courseservice courseservice;
    @Autowired
    adduserservice userservice;



    @PostMapping("/add-users")
    public void adduser(@RequestBody Users user)
    {
        userservice.adduser(user);
    }
}
