package com.example.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PassportAppDetails {
	
	private Integer appId;
	private String passportNum;
	private Integer personId;
	private String fname;
	private String lname;
	private String email;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dob;
	private String gender;
	private Long adhaarNo;
	private Integer eduId;
	private String highdegree;
	private String university;
	private Integer passedyear;

}
