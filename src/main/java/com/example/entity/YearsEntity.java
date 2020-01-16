package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="YEARS_MASTER")
public class YearsEntity {
	
	@Id
	@Column(name="YEAR_ID")
	private Integer yearId;
	
	@Column(name="YEAR")
	private Integer year;

}
