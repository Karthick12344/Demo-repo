package com.example.EmployeeJPAProject.Pojo;

public class EmpProjPojo {
    private String projectName;
    private String projectCode;

    public EmpProjPojo() {

    }
    public EmpProjPojo(String projectName, String projectCode) {
        this.projectName = projectName;
        this.projectCode = projectCode;
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
}
