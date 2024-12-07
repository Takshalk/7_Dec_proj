package com.example.Emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id; // Primary key
    private long sal;
    private String name;
    private String loc;
    
    
    public Emp() {
		super();
	}

	@Override
	public String toString() {
		return "Emp [emp_id=" + emp_id + ", sal=" + sal + ", name=" + name + ", loc=" + loc + "]";
	}

	public Emp(int emp_id, long sal, String name, String loc) {
		super();
		this.emp_id = emp_id;
		this.sal = sal;
		this.name = name;
		this.loc = loc;
	}

    // Getters and Setters (optional but recommended for JPA)
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public long getSal() {
        return sal;
    }

    public void setSal(long sal) {
        this.sal = sal;
    }

   

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
