package com.example.EmployeeJPAProject.Entity;

import jakarta.persistence.*;

@Entity
public class AddrsEntity {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name = "address_id")
private Integer addressId;
private String area;
private String city;
private String state;
private String country;

    public AddrsEntity() {

    }
    public AddrsEntity(String area, String city, String state, String country) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
