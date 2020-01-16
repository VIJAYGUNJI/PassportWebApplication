package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.EducationDetailsEntity;
import com.example.entity.PersonDetailsEntity;
import com.example.model.EducationDetails;
import com.example.model.PassportAppDetails;
import com.example.model.PersonDetails;

public interface PassportDetailsService {
	
	
	public   PersonDetails viewPersonDetailsForm(PersonDetails pdetails);
	public EducationDetails viewEducationDetailsForm(EducationDetails edetails);
	
	public List<String>  getAllDegrees();
	
	public List<String> getAllUniversities();
	
	public List<Integer> getAllYears();
	
	public Optional<PersonDetailsEntity> fetchPersonDetailsById(Integer personId);
	public  Optional<EducationDetailsEntity>  fetchEducationDetailsById(Integer eduId);
	
	public PassportAppDetails getAppReviewForm(PassportAppDetails pdetails);
	
	public String generateRandomPassword(int len);
	
//	public EducationDetailsEntity getEdDetailsById(Integer eid);
	
}





