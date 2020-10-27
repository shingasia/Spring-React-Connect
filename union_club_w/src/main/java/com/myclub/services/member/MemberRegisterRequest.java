package com.myclub.services.member;

public class MemberRegisterRequest {
    
    //id, password, confirmpassword, address, email
    private String id;
    private String password;
    private String confirmpassword;
    private String name;
    private String address;
    private String email;

    public MemberRegisterRequest(){ }

    public MemberRegisterRequest(String id, String password, String confirmpassword, String name, String address,
            String email) {
        this.id = id;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}