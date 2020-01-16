package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DEGREES_MASTER")
public class DegreesEntity {
	
	@Id
	@Column(name="DEGREE_ID")
	private Integer degreeId;
	
	@Column(name="DEGREE_NAME")
	private String degreename;

}
