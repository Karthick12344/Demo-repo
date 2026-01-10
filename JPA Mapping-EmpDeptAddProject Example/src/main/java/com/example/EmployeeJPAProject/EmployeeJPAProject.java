package com.example.EmployeeJPAProject;

import com.example.EmployeeJPAProject.Entity.AddrsEntity;
import com.example.EmployeeJPAProject.Entity.DeptEntity;
import com.example.EmployeeJPAProject.Entity.EmpEntity;
import com.example.EmployeeJPAProject.Entity.EmpProjEntity;
import com.example.EmployeeJPAProject.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EmployeeJPAProject implements CommandLineRunner {
    @Autowired
    private EmployeeRepo employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeJPAProject.class, args); }

        @Override
        public void run (String[] args) throws Exception {



            DeptEntity department = new DeptEntity("IT", "IT123");

            AddrsEntity address = new AddrsEntity("Kolathur","Chennai", "TamilNadu", "India");

            EmpProjEntity project1 = new EmpProjEntity("ONA", "ONA1234");
            EmpProjEntity project2 = new EmpProjEntity("Lending", "L1234");

            List<EmpProjEntity> projects = Arrays.asList(project1, project2);


            EmpEntity employee = new EmpEntity(2222, "Karthick", "MicroService");

            employee.setDepartment(department);
            employee.setAddress(address);
            employee.setProject(projects);
            employeeRepo.save(employee);

        }

    }
