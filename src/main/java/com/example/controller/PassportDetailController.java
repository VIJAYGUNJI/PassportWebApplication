package com.example.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.EducationDetailsEntity;
import com.example.entity.PersonDetailsEntity;
import com.example.model.PassportAppDetails;
import com.example.service.PassportServiceImpl;

@Controller
public class PassportDetailController {
	
	@Autowired
	private PassportServiceImpl pservice;
	
	
	
	@RequestMapping("/getAppReviewForm")
	public String viewPassportReviewPage(Model model,HttpServletRequest req)
	{
		PassportAppDetails pdetails=new PassportAppDetails();
		
		String eid=req.getParameter("eId");
		Integer edid=null;
		if(eid !=null && !eid.isEmpty())
		{
			edid=Integer.parseInt(eid);
			pdetails.setPersonId(edid);
		
		}
		Optional<EducationDetailsEntity> edOptional = pservice.fetchEducationDetailsById(edid);
		EducationDetailsEntity educationDetailsEntity = edOptional.get();
		
		Integer pid = educationDetailsEntity.getPersonId();
		
		Optional<PersonDetailsEntity> optPerson = pservice.fetchPersonDetailsById(pid);
		PersonDetailsEntity personDetailsEntity = optPerson.get();
		
		PassportAppDetails passpostDetails = new PassportAppDetails();
		BeanUtils.copyProperties(personDetailsEntity, passpostDetails);
		BeanUtils.copyProperties(educationDetailsEntity, passpostDetails);
		
		
		model.addAttribute("passport",passpostDetails);
		return "reviewForm";
	}

	@RequestMapping(value="/submitReviewForm", method=RequestMethod.POST)
	public  String handleSubmitButton(@ModelAttribute("passport")PassportAppDetails pdetails,Model model)
	{
		PassportAppDetails pd= pservice.getAppReviewForm(pdetails);
		/*if(pd!=null)
		{
			model.addAttribute("successMsg","Your Passport details are added successfully");
			
			model.addAttribute("passportNum",pd.getPassportNum());
			System.out.println("Passport no::"+pd.getPassportNum());
		}
		else
		{
			model.addAttribute("errorMsg","Your Passport number Generation Failed");
		}*/
		return "redirect:/passportDashBoard";	
	}
	@RequestMapping(value = "/passportDashBoard")
	public String enterIntoPassportDashBoard(@ModelAttribute("passport")PassportAppDetails pdetails,Model model) {
		
		PassportAppDetails pappdetails= pservice.getAppReviewForm(pdetails);
		if(pappdetails!=null)
		{
			model.addAttribute("successMsg","Your Passport details are added successfully");
			model.addAttribute("passportNum",pappdetails.getPassportNum());
			System.out.println("passport no::"+pappdetails.getPassportNum());
		}
		return "passportDashBoard";
	}
}
