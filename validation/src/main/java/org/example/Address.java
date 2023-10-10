package org.example;

import jakarta.validation.constraints.NotBlank;

public class Address {

    @NotBlank(message = "street must be not blank")
    private String street;
    @NotBlank(message = "city must be not blank")
    private String city;
    @NotBlank(message = "state must be not blank")
    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
