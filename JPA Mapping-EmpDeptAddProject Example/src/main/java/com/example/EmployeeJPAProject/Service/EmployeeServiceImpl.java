package com.example.EmployeeJPAProject.Service;

import com.example.EmployeeJPAProject.Entity.EmpEntity;
import com.example.EmployeeJPAProject.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
public EmpEntity addEmployee(EmpEntity employee)
{
    return employeeRepo.save(employee);
}

/*
    public EmployeeEntity fetchEmployeeById(Integer id) {
        return employeeRepo.fetchEmployeeById(id);
    }

    public EmployeeEntity deleteEmployeeById(Integer id) {
        return employeeRepo.deleteEmployeeEntityById(id);
    }
*/

}
