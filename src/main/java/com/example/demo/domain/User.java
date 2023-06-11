package com.example.demo.domain;

public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String pasword;
    
    public User(Integer userId, String firstName, String lastName, String email, String pasword) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pasword = pasword;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPasword() {
        return pasword;
    }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    
}
