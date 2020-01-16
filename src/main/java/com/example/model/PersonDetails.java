package com.example.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonDetails {

	private  Integer personId;
	private String fname;
	private String lname;
	private String email;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dob;
	private String gender;
	private Long adhaarNo;
	
}
