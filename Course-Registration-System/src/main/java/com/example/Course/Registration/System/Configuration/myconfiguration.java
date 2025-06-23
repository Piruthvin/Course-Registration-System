package com.example.Course.Registration.System.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class myconfiguration {
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/login.html", "/script.js", "/register.html", "/index.html").permitAll()
                .requestMatchers("/courses/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html") // your custom login page
                .defaultSuccessUrl("/index.html", true)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login.html")
                .permitAll();
    }
}
