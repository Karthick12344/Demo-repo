package com.example.EmployeeJPAProject.Pojo;

public class AddrsPojo {
    private String area;
    private String city;
    private String state;
    private String country;

    public AddrsPojo() {

    }
    public AddrsPojo(String area, String city, String state, String country) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
