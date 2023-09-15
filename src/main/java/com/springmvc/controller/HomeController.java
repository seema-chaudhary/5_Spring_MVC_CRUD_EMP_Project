package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.EmpDao;
import com.springmvc.entity.Emp;

@Controller
public class HomeController {

	@Autowired
	private EmpDao empDao;
	
	@RequestMapping(path="/home")
	public String home(Model m)
	{
		List<Emp> list= empDao.getAllEmp();
		m.addAttribute("empList", list);
		return "home";
	}

	@RequestMapping(path="/addEmp")
	public String addEmp()
	{
		return "addEmp";
	}

	@RequestMapping(path="/createEmp", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute Emp emp, HttpSession session)
	{
		System.out.println(emp);	
		int i=empDao.saveEmp(emp);
		session.setAttribute("msg", "Registration Successfully.....");
		return "redirect:/addEmp";
	}	
	
}
