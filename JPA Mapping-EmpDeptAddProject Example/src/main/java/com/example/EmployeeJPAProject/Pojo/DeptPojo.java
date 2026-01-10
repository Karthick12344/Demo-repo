package com.example.EmployeeJPAProject.Pojo;

public class DeptPojo {
    private String deptName;
    private String deptCode;

    public DeptPojo() {

    }

    public DeptPojo(String deptName, String deptCode) {
        this.deptName = deptName;
        this.deptCode = deptCode;
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
}
