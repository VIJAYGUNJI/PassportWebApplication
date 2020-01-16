package com.example.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EducationDetailsEntity;
import com.example.entity.PassportDetailsEntity;
import com.example.entity.PersonDetailsEntity;
import com.example.model.EducationDetails;
import com.example.model.PassportAppDetails;
import com.example.model.PersonDetails;
import com.example.repository.DegreesRepository;
import com.example.repository.EducationDetailsRepository;
import com.example.repository.PassportDetailsRepository;
import com.example.repository.PersonDetailsRepository;
import com.example.repository.UniversityRepository;
import com.example.repository.YearsRepository;

@Service
public class PassportServiceImpl implements PassportDetailsService {
	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom rnd = new SecureRandom();
	

	@Autowired
	private PersonDetailsRepository personrepo;
	
	@Autowired
	private EducationDetailsRepository edurepo;
	
	@Autowired
	private DegreesRepository degreerepo;
	
	@Autowired
	private YearsRepository yearsrepo;
	
	@Autowired
	private UniversityRepository univrepo;
	
	@Autowired
	private PassportDetailsRepository passrepo;
	
	
	
	
	@Override
	public PersonDetails viewPersonDetailsForm(PersonDetails pdetails) {
		PersonDetailsEntity entity=new PersonDetailsEntity();
		BeanUtils.copyProperties(pdetails, entity);
		System.out.println("entity    "+entity);
		PersonDetailsEntity save = personrepo.save(entity);
		 BeanUtils.copyProperties(save, pdetails);
		return pdetails;
	}
	
	
	@Override
	public List<String> getAllDegrees() {
		return degreerepo.getallDegrees();
	}
	
	
	@Override
	public List<String> getAllUniversities() {
		System.out.println(univrepo.getAllUniversities());
		return univrepo.getAllUniversities();
	}
	
	@Override
	public List<Integer> getAllYears() {
		return yearsrepo.getAllYears();
	}
	
	
	@Override
	public Optional<PersonDetailsEntity> fetchPersonDetailsById(Integer personId) {
		return personrepo.findById(personId);
	}
	
	@Override
	public EducationDetails viewEducationDetailsForm(EducationDetails edetails) {

		EducationDetailsEntity eduentity=new EducationDetailsEntity();
		BeanUtils.copyProperties(edetails, eduentity);
	EducationDetailsEntity save = edurepo.save(eduentity);
	if(save!=null)
	{
		BeanUtils.copyProperties(save, edetails);
	}
return edetails;
}
	@Override
	public Optional<EducationDetailsEntity> fetchEducationDetailsById(Integer eduId) {
		return edurepo.findById(eduId);
	}
	
	/*@Override
	public EducationDetails fetchEducationDetailsById(Integer eduId) {
		EducationDetails ed=new EducationDetails();
		Optional<EducationDetailsEntity> findById = edurepo.findById(eduId);
		if(findById!=null)
		{
			EducationDetailsEntity ee=findById.get();
			BeanUtils.copyProperties(ee, ed);
			
		}
		return ed;
	}*/
	@Override
	public PassportAppDetails getAppReviewForm(PassportAppDetails pdetails) {
		pdetails.setPassportNum(generateRandomPassword(10));
		PassportDetailsEntity entity=new PassportDetailsEntity();
		BeanUtils.copyProperties(pdetails, entity);
		PassportDetailsEntity save = passrepo.save(entity);
		if(save!=null)
		{
			BeanUtils.copyProperties(save, pdetails);
		}
		return pdetails;
	}
	
	@Override
	public String generateRandomPassword(int len) {
		StringBuilder sb=new StringBuilder(len);
		for(int i=0;i<len;i++)
		{
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}	
		return sb.toString();
	}
	
	/*@Override
	public EducationDetailsEntity getEdDetailsById(Integer eid) {
	Optional<EducationDetailsEntity> findById = edurepo.findById(eid);
	EducationDetailsEntity edEntity = findById.get();
		return edEntity;
	}*/
}