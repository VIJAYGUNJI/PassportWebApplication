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
@Table(name="EDU_DTLS")
@Data
public class EducationDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name="EDU_ID")
	private Integer eduId;
	
	@Column(name="HIGH_DEGREE",length=30)
	private String highdegree;
	
	@Column(name="UNIVERSITY",length=30)
	private String university;
	
	@Column(name="PASSED_YEAR",length=10)
	private Integer passedyear;
	
	@Column(name="PERSON_ID",length=10)
	private Integer personId;
	
	@CreationTimestamp
	@Column(name="CREATED_DT")
	private Date createddate;
	
	@UpdateTimestamp
	@Column(name="UPDATE_DT")
	private Date updatedate;

}
