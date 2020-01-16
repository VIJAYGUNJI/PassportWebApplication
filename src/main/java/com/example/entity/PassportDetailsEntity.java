package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="PASSPORT_MASTER")
public class PassportDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name="APP_ID")
	private Integer appId;
	
	@Column(name="PASSPORT_NUM",length=20)
	private String passportNum;
	
	@Column(name="PERSON_ID",length=10)
	private Integer personId;

}
