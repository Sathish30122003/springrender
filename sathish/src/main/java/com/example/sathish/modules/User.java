package com.example.sathish.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="user")
public class User {

    @Id
    private String aadhar;
    @Field
    private String name;
    @Field
    private String email;
    @Field
    private String place;

    public User() {
    }

    public User(String aadhar, String name, String email, String place) {
        this.aadhar = aadhar;
        this.name = name;
        this.email = email;
        this.place = place;
    }


    public String getAadhar() {
        return aadhar;
    }
    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return String.format("User[aadhar='%s', name='%s', email='%s', place='%s']", aadhar, name, email, place);
    }
}
