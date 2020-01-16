package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.EducationDetailsEntity;
import com.example.entity.PersonDetailsEntity;
import com.example.model.EducationDetails;
import com.example.model.PersonDetails;
import com.example.service.PassportServiceImpl;

@Controller
public class EducationDetailController {
	@Autowired
	private PassportServiceImpl psimpl;
	
	
	@RequestMapping("/getEduForm")
	public String getEducationForm(Model model, HttpServletRequest req)
	{
		EducationDetails edetails=new EducationDetails();
		String personId=req.getParameter("personId");
		if(personId !=null && !personId.isEmpty())
		{
			Integer pid=Integer.parseInt(personId);
			edetails.setPersonId(pid);
		}
		
		List<String> degreeslist=psimpl.getAllDegrees();
		model.addAttribute("degrees",degreeslist);
		
		List<String>  universitieslist=psimpl.getAllUniversities();
		model.addAttribute("universities",universitieslist);
		
		List<Integer> yearslist=psimpl.getAllYears();	
		model.addAttribute("years",yearslist);
		model.addAttribute("education",edetails);
		System.out.println("gjcjg"+edetails);
		return "educationForm";
	}

	@RequestMapping(value="/submitEduForm", method=RequestMethod.POST)
	public String handleNextButton(@ModelAttribute("education")EducationDetails edu, Model model)
	{
						
		EducationDetails viewEducationDetailsForm = psimpl.viewEducationDetailsForm(edu);
	if(viewEducationDetailsForm!=null)
		{
			Optional<PersonDetailsEntity> fetchPersonDetailsById = psimpl.fetchPersonDetailsById(edu.getPersonId());
			
			PersonDetailsEntity pentity=fetchPersonDetailsById.get();
			System.out.println("Person Details::"+pentity);
			model.addAttribute("person",pentity);
			
			Optional<EducationDetailsEntity> fetchEducationDetailsById = psimpl.fetchEducationDetailsById(edu.getEduId());
			EducationDetailsEntity eduentity=fetchEducationDetailsById.get();
			System.out.println("Education details::"+eduentity);
			
			model.addAttribute("education",eduentity);	
		}
		return "redirect:/getAppReviewForm?eId="+edu.getEduId();
		
	}
	
}
