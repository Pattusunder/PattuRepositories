package com.example.crud.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
     @Column(name="name",nullable=false)
	private String name;
     @Column(name="age")
	private int age;
     @Column(name="salaryl")
	private int salaryl;
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}
	public Object getAge() {
		// TODO Auto-generated method stub
		return age;
	}
	public void setAge(Object age2) {
		// TODO Auto-generated method stub
		
	}
	public Object getSalaryl() {
		// TODO Auto-generated method stub
		return salaryl;
	}
	public void setSalaryl(Object salary2) {
		// TODO Auto-generated method stub
		
	}
}
