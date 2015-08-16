package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import requests.EmployeeGroupRequest;
import requests.EmployeeMessagesRequest;
import requests.HrMessagesRequest;
import responses.MessagesResponse;
import Entities.*;

public interface OnBoardingPortalController {

	// TODO:add methods after changing signature
	
	
	
	
	public ModelAndView loadAllEmpPosts(HttpServletRequest request,
			HttpServletResponse response,ModelMap map);
	
	
	
	@RequestMapping("empmsgposts.htm")
	public ModelAndView loadGrpEmpPosts(HttpServletRequest request,HttpServletResponse response,ModelMap map);
	
	@RequestMapping("empmainpage.htm")
	public ModelAndView EmpMainPage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map);

	
	@RequestMapping("empprofpage.htm")
	public ModelAndView EmpProfPage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map);
	
	@RequestMapping("empupdateprofpage.htm")
	public ModelAndView EmpUpdateProfPage(HttpServletRequest request,HttpServletResponse response,ModelMap map);
	
	@RequestMapping("validate.htm")
	public ModelAndView loginUser(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("user") User user);

	// TODO: put url and model attribute
	@RequestMapping("logout.htm")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response);

	// TODO: put url and model attribute

	@RequestMapping("preAddHR.htm")
	public ModelAndView preaddHR(HttpServletRequest request,
			HttpServletResponse response, ModelMap map);
	
	// Start of Chandu
	@RequestMapping("addHR.htm")
	public ModelAndView addHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("hr") HR hr);

	
	@RequestMapping("preAddEmployee.htm")
	public ModelAndView preaddEmployee(HttpServletRequest request,
			HttpServletResponse response, ModelMap map);
	
	@RequestMapping("addEmployee.htm")
	public ModelAndView addEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("emp") Employee employee);
	
	
	@RequestMapping("preRemoveEmployee.htm")
	public ModelAndView preremoveEmployee(HttpServletRequest request,
			HttpServletResponse response, ModelMap map);
	
	@RequestMapping("removeEmployee.htm")
	public ModelAndView removeEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("emp") Employee employee);
	

	@RequestMapping("addgroup.htm")
	public ModelAndView addGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("group") Group group);

	public ModelAndView addMessage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("message") Message message);

	@RequestMapping("updateEmpProfile.htm")
	public ModelAndView updateProfileOfEmployee(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("currentEmployee") Employee employee);

	@RequestMapping("")
	public ModelAndView updateProfileOfHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr);


	@RequestMapping("")
	public ModelAndView generatePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr);

	

	@RequestMapping("preaddgroup.htm")
	public ModelAndView preAddGroup(HttpServletRequest request,
			HttpServletResponse response, ModelMap map);
	
	@RequestMapping("predeletegroup.htm")
	public ModelAndView preRemoveGroup(HttpServletRequest request,
			HttpServletResponse response, ModelMap map);
	
	@RequestMapping("deletegroup.htm")
	public ModelAndView removeGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("group") Group group);

	@RequestMapping("newSession.htm")
	public ModelAndView newSession(HttpServletRequest request,
			HttpServletResponse response, ModelMap map);

	@RequestMapping("preaddemployee.htm")
	public ModelAndView preAddEmployeeToGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map);
	
	@RequestMapping("addemptogrp.htm")
	public ModelAndView addEmployeeToGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map,@ModelAttribute("employeegrp") EmployeeGroup empGrp );

	@RequestMapping("predeleteemployee.htm")
	public ModelAndView preRemoveEmployeeFromGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map);
	
	@RequestMapping("removegroup.htm")
	public ModelAndView removeEmployeeFromGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map,@ModelAttribute("employeegrp") EmployeeGroupRequest empgrp);

	@RequestMapping("removepost.htm")
	public ModelAndView removeMessage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("message") Message message);	
	@RequestMapping("hrallposts.htm")
	public ModelAndView getAllPostsForHr(HttpServletRequest request,
			HttpServletResponse response, HrMessagesRequest hrMessageRequest, ModelMap map);

	@RequestMapping("empmsgfromgrp.htm")
	public ModelAndView getPostsForEmployee(HttpServletRequest request,
			HttpServletResponse response,
			EmployeeMessagesRequest employeeMessagesRequest, ModelMap map);
	
	
	@RequestMapping("hrmsgfromgrp.htm")
	public ModelAndView getPostsForHr(HttpServletRequest request,
			HttpServletResponse response,
			HrMessagesRequest hrMessagesRequest, ModelMap map);

	public ModelAndView getAllEmployeesOfGroup(HttpServletRequest request,
			HttpServletResponse response, Group group);
	
	public MessagesResponse getAllPosts(Employee emp);
	
	
	public ArrayList<MessageGroup> getMessageGroupList(MessagesResponse msgResponse);

}
