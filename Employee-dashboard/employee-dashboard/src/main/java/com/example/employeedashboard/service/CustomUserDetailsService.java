package com.example.employeedashboard.service;

import com.example.employeedashboard.entity.Employee;
import com.example.employeedashboard.repository.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Attempting to authenticate user: {}", username);

        Employee employee = employeeRepository.findByEname(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String password = String.valueOf(employee.getSal()); // Convert Double to String

        logger.info("Found user: {}", employee.getEname());
        logger.info("Password from DB (SAL): {}", password);

        return new User(employee.getEname(), password, Collections.emptyList());
    }

}
