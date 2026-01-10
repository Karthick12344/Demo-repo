package com.example.EmployeeJPAProject.Controller;

import com.example.EmployeeJPAProject.Entity.EmpEntity;
import com.example.EmployeeJPAProject.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @PostMapping("/add")
    public EmpEntity addEmployee(@RequestBody EmpEntity employee) {
        return employeeService.addEmployee(employee);
    }

   /* @GetMapping("/get/{id}")
    public EmployeeEntity getEmployee(@PathVariable Integer id) {
        return employeeService.fetchEmployeeById(id);
    }

    @GetMapping("/delete/{id}")
    public EmployeeEntity deleteEmployeeId(@PathVariable Integer id) {
        return employeeService.deleteEmployeeId(id);
    }*/

}
