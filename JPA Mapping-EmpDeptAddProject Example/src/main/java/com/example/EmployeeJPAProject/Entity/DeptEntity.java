package com.example.EmployeeJPAProject.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Integer departmentId;
    @Column(name="dept_name")
    private String deptName;
    @Column(name="dept_code")
    private String deptCode;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmpEntity> employees;

    public DeptEntity() {

    }
    public DeptEntity(String deptName, String deptCode) {
        this.deptName = deptName;
        this.deptCode = deptCode;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getDeptCode() {
        return deptCode;
    }
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    public List<EmpEntity> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmpEntity> employees) {
        this.employees = employees;
    }
}
