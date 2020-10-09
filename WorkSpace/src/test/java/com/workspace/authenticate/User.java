package com.workspace.authenticate;

public class User {

    private String name;
    private String dob;
    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public String getDob() {
        return this.dob;
    }

    public String getCountry() {
        return this.country;
    }
}
