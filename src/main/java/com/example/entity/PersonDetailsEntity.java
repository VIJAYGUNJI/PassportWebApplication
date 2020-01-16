package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="PERSON_DETAILS")
@Data
public class PersonDetailsEntity {
	
	@Id
	@GeneratedValue
	private Integer personId;
	@Column(length=20,name="FNAME")
	private String fname;
	@Column(length=20,name="LNAME")
	private String lname;
	@Column(length=30,name="EMAIL")
	private String email;
	@Column(length=20,name="DOB")
	private Date dob;
	@Column(length=20,name="GENDER")
	private String gender;
	@Column(length=20,name="ADHAARNO")
	private long adhaarNo;
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private Date createddate;
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	private Date updateddate;
}
