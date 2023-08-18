package com.example.jktvehicleapp.modelClass;

public class Login {
    String name,mobile,email;

    public Login(String mobile, String email) {
        this.mobile = mobile;
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
