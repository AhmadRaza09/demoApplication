package com.login.helper;

public class HelperUserRecords {
    private  int id;
    private int num;
    private String name;
    private String email;
    private  String gender;
    private String mobile;
    private String role;
    private int status;



    public HelperUserRecords()
    {
        setId(0);
        setNum(0);
        setName("No Name");
        setEmail("No Email");
        setGender("No gender");
        setMobile("No mobile");
        setRole("No Role");
        setStatus(0);
    }

    public HelperUserRecords(int id, int num, String name, String email, String gender, String mobile, String role, int status)
    {
        setId(id);
        setNum(num);
        setName(name);
        setEmail(email);
        setGender(gender);
        setMobile(mobile);
        setRole(role);
        setStatus(status);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
