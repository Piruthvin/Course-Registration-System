package com.example.Course.Registration.System.Service;

import com.example.Course.Registration.System.Model.Users;
import com.example.Course.Registration.System.Repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class adduserservice {

    @Autowired
    BCryptPasswordEncoder PasswordEncoder;

    @Autowired
    UserDetailsRepo repo;

    public void adduser(Users user) {
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
}
