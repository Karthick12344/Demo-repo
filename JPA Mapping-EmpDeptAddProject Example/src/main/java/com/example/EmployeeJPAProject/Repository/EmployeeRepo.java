package com.example.EmployeeJPAProject.Repository;


import com.example.EmployeeJPAProject.Entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmpEntity,Integer> {

    /*
    EmployeeEntity fetchEmployeeById(Integer id);

    EmployeeEntity deleteEmployeeEntityById(Integer id);
    */

}