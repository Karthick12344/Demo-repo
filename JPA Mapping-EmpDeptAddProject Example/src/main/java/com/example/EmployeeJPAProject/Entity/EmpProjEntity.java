package com.example.EmployeeJPAProject.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EmpProjEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Integer projectId;
    private String projectName;
    private String projectCode;
    @ManyToMany(mappedBy = "projects")
    private List<EmpEntity> employees;

    public EmpProjEntity() {

    }

    public EmpProjEntity(String projectName, String projectCode) {
        this.projectName = projectName;
        this.projectCode = projectCode;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
    public List<EmpEntity> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmpEntity> employees) {
        this.employees = employees;
    }
}
