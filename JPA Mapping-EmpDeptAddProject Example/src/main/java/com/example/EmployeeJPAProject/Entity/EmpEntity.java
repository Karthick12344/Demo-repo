package com.example.EmployeeJPAProject.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EmpEntity {
    @Id
    @Column(name="employee_id")
    private Integer employeeId;
    @Column(name="employee_name")
    private String employeeName;
    private String designation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddrsEntity address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private DeptEntity department;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<EmpProjEntity> projects;

    public EmpEntity() {

    }

    public EmpEntity(Integer employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public AddrsEntity getAddress() {
        return address;
    }
    public void setAddress(AddrsEntity address) {
        this.address = address;
    }

    public DeptEntity getDepartment() {
        return department;
    }
    public void setDepartment(DeptEntity department) {
        this.department = department;
    }

    public List<EmpProjEntity> getProject() {
        return projects;
    }
    public void setProject(List<EmpProjEntity> projects) {
        this.projects = projects;
    }
}
