package com.example.jktvehicleapp.modelClass;

public class Register {
    String name,mobile,password,confirm_password;

    public Register(String name, String mobile, String password, String confirm_password) {
        this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public Register (String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

}
