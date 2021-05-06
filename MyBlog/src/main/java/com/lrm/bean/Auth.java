package com.lrm.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "t_auth")
@Entity
public class Auth {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;

    private String name;


    private String password;

    @ManyToMany
    private List<Department> departments = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}