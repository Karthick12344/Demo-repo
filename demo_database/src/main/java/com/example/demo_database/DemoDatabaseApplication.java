package com.example.demo_database;

import com.example.demo_database.controller.DepartmentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoDatabaseApplication {

   public static void main(String[] args) {
        SpringApplication.run(DemoDatabaseApplication.class, args);
    }

    Logger logger = LoggerFactory.getLogger(DemoDatabaseApplication.class);

}
