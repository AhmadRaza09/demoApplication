package com.login.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Role_Id")
    private Role role;

//    @Column(name = "Role_Id")
//    private int role_id;

    //************************** getter n setters ***********************************//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public int getRole_id() {
//        int role_id = role.getId();
//        return role_id;
//    }
//
//    public void setRole_id(int role_id) {
//        if(role_id < 1)
//            role_id = this.role.getId();
//
//        this.role_id = role_id;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
