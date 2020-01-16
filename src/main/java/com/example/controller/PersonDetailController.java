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

import com.example.entity.PersonDetailsEntity;
import com.example.model.PersonDetails;
import com.example.service.PassportServiceImpl;

@Controller
public class PersonDetailController {
	@Autowired
	private PassportServiceImpl pservice;
	
	@RequestMapping("/")
	public String savePersonDetails(Model model,HttpServletRequest req)
	{
		
	String id = req.getParameter("personId");
	  PersonDetails pdetails=new PersonDetails();
		/*if(id!=null & !id.isEmpty())
		{
			Integer  pid=Integer.parseInt(id);
			Optional<PersonDetailsEntity> fetchPersonDetailsById = pservice.fetchPersonDetailsById(pid);
			if(fetchPersonDetailsById.isPresent())
			{
				PersonDetailsEntity pde=fetchPersonDetailsById.get();
				BeanUtils.copyProperties(pde, pdetails);
			}

		}*/
		model.addAttribute("person" ,pdetails);
		return "persondetails";
	}
	
	@RequestMapping(value="/getPersonDataById",method=RequestMethod.GET)
	public String fetchPersonInfoById(Model model,HttpServletRequest req)
	{
		
		String id = req.getParameter("personId");
		PersonDetails pdetails=new PersonDetails();
		if(id!=null & !id.isEmpty())
		{
			Integer  pid=Integer.parseInt(id);
			Optional<PersonDetailsEntity> fetchPersonDetailsById = pservice.fetchPersonDetailsById(pid);
			if(fetchPersonDetailsById.isPresent())
			{
				PersonDetailsEntity pde=fetchPersonDetailsById.get();
				BeanUtils.copyProperties(pde, pdetails);
			}
       model.addAttribute("person" ,pdetails);
		}
		return "persondetails";
	}
	
	@RequestMapping(value="/submitForm",method=RequestMethod.POST)
	public String handleSubmitButton(@ModelAttribute("person")PersonDetails pdetails,Model model)
	{
		System.out.println("hgc::"+pdetails);
		 PersonDetails viewPersonDetailsForm = pservice.viewPersonDetailsForm(pdetails);
		 
		return "redirect:/getEduForm?personId="+viewPersonDetailsForm.getPersonId();
	}
	 

}
