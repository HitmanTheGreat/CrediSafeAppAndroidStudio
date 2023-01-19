package com.example.credisafe.model;

public class Login {
    private String national_id;
    private String pin;

    public Login(String national_id, String pin){
        this.national_id = national_id;
        this.pin = pin;
    }
}
