package com.example.employeedashboard.controller;

import com.example.employeedashboard.entity.Employee;
import com.example.employeedashboard.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Get logged-in username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();  // This gets the logged-in username (ename)

        System.out.println("Logged-in User: " + username); // Debug log

        // Fetch employee details
        Optional<Employee> employeeOptional = employeeRepository.findByEname(username);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            model.addAttribute("employee", employee);
            System.out.println("Employee Found: " + employee.getEname()); // Debug log
        } else {
            model.addAttribute("error", "Employee not found!");
            System.out.println("Employee Not Found!"); // Debug log
        }

        return "dashboard";  // Ensure dashboard.html is present in `src/main/resources/templates/`
    }
}
