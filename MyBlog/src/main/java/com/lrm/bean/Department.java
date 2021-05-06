package com.lrm.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_depart")
public class Department {

    @Id
    @GeneratedValue
    private Integer id;

    private String depName;

   @ManyToMany(mappedBy = "departments")
    private List<Auth> auths = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + "]";
	}
    
}