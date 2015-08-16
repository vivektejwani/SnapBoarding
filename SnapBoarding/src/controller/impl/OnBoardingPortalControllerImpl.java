package controller.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import requests.EmployeeGroupRequest;
import requests.EmployeeMessagesRequest;
import requests.HrMessagesRequest;
import responses.MessagesResponse;
import controller.OnBoardingPortalController;
import DAO.OnBoardingPortalDAO;
import Entities.*;

@Controller
public class OnBoardingPortalControllerImpl implements OnBoardingPortalController {

	OnBoardingPortalDAO onBoardingPortalDAO;
	public OnBoardingPortalControllerImpl() 
	{
		
		onBoardingPortalDAO = (OnBoardingPortalDAO) new ClassPathXmlApplicationContext("/applicationContext.xml").getBean("OnBoardingPortalDAOImpl");
	}

	// TODO: put url and model attribute
	@RequestMapping("empallposts.htm")
	public ModelAndView loadAllEmpPosts(HttpServletRequest request,
			HttpServletResponse response,ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Employee currentEmp = (Employee) session.getAttribute("user");
		
		MessagesResponse allPosts = getAllPosts(currentEmp);
		
		ArrayList<MessageGroup> msgGrp = getMessageGroupList(allPosts);
		int currentPage = 1;
		int noOfPages = msgGrp.size()/5;
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		map.addAttribute("messages", msgGrp);
		map.addAttribute("currentPage", currentPage);
		map.addAttribute("noOfPages", noOfPages);
		map.addAttribute("opt", "all");
		modelAndView.setViewName("employee");
		
		return modelAndView;
	}
	
	
	
	@RequestMapping("empmsgposts.htm")
	public ModelAndView loadGrpEmpPosts(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Employee currentEmp = (Employee) session.getAttribute("user");
		
		MessagesResponse allPosts = getAllPosts(currentEmp);
		
		ArrayList<MessageGroup> msgGrp = getMessageGroupList(allPosts);
		int currentPage = 1;
		int noOfPages = msgGrp.size()/5;
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		map.addAttribute("messages", msgGrp);
		map.addAttribute("currentPage", currentPage);
		map.addAttribute("noOfPages", noOfPages);
		map.addAttribute("opt", "all");
		modelAndView.setViewName("employee");
		
		return modelAndView;
	}
	
	@RequestMapping("empmainpage.htm")
	public ModelAndView EmpMainPage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		map.addAttribute("opt","all");
		modelAndView.setViewName("employee");
		return loadAllEmpPosts(request, response, map);
	}

	
	@RequestMapping("empprofpage.htm")
	public ModelAndView EmpProfPage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Employee currentEmployee = (Employee) session.getAttribute("user");
		map.addAttribute("currentEmp", currentEmployee);
		map.addAttribute("opt","profile");
		modelAndView.setViewName("employee");
		return modelAndView;
	}
	
	@RequestMapping("empupdateprofpage.htm")
	public ModelAndView EmpUpdateProfPage(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		Employee currentEmployee = (Employee) session.getAttribute("user");
		map.addAttribute("currentEmp", currentEmployee);
		map.addAttribute("opt","update_profile");
		modelAndView.setViewName("employee");
		return modelAndView;
	}
	
	@RequestMapping("validate.htm")
	public ModelAndView loginUser(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("user") User user) {

		ModelAndView modelAndView = new ModelAndView();

		if (user.getType().equalsIgnoreCase("employee")) {

			Employee employee = new Employee(user.getEmail(),
					user.getPassword());
			Employee employeeFromDAO = new Employee();
			employeeFromDAO=onBoardingPortalDAO.validateEmployee(employee);
			if (employeeFromDAO != null) 
			{
				
				HttpSession session = request.getSession();
				session.setAttribute("user", employeeFromDAO);
				return loadAllEmpPosts(request, response, map);
			}
		} else if (user.getType().equalsIgnoreCase("hr")) {

			HR hr = new HR(user.getEmail(), user.getPassword());

			HR hrFromDAO = onBoardingPortalDAO.validateHr(hr);

			if (hrFromDAO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", hrFromDAO);
				return getAllPostsForHr(request, response, null, map);
			}
		} else if (user.getType().equalsIgnoreCase("admin")) {

			Admin admin = new Admin(user.getEmail(), user.getPassword());

			Admin adminFromDAO = onBoardingPortalDAO.validateAdmin(admin);

			if (adminFromDAO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", admin);
				modelAndView.setViewName("admin");
				return modelAndView;
			}
		}

		
		return new ModelAndView("index");

	}


	@RequestMapping("logout.htm")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		HttpSession session = request.getSession();
		session.invalidate();

		// TODO: set view name
		modelAndView.setViewName("index");
		return modelAndView;
	}



	@RequestMapping("preAddHR.htm")
	public ModelAndView preaddHR(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) {

			HR hr=new HR();
			map.addAttribute("hr",hr);
			System.out.println("passs");
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("addHR");
			System.out.println("pass2");
			return modelAndView;
	}
	
	// Start of Chandu
	@RequestMapping("addHR.htm")
	public ModelAndView addHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("hr") HR hr) {

		ModelAndView modelAndView = new ModelAndView();
			if(onBoardingPortalDAO.addHr(hr)){
				modelAndView.setViewName("admin");
				return modelAndView;
			}else{
				modelAndView.setViewName("admin");
				return modelAndView;			
			}	
	}

	
	@RequestMapping("preAddEmployee.htm")
	public ModelAndView preaddEmployee(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) {

			Employee emp=new Employee();
			map.addAttribute("emp",emp);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("addEmp");
			return modelAndView;
	}
	
	@RequestMapping("addEmployee.htm")
	public ModelAndView addEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("emp") Employee employee) {
		employee.setDesignation("SDE");
		ModelAndView modelAndView = new ModelAndView();
			if(onBoardingPortalDAO.addEmployee(employee)){
				modelAndView.setViewName("admin");
				return modelAndView;
			}else{
				modelAndView.setViewName("admin");
				return modelAndView;

			}
			
		
	}
	
	
	@RequestMapping("preRemoveEmployee.htm")
	public ModelAndView preremoveEmployee(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) {

			Employee emp=new Employee();
			map.addAttribute("emp",emp);
			ModelAndView modelAndView=new ModelAndView();
			
			modelAndView.setViewName("removeEmp");
			return modelAndView;
	}
	
	@RequestMapping("removeEmployee.htm")
	public ModelAndView removeEmployee(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("emp") Employee employee) {

		ModelAndView modelAndView = new ModelAndView();
			if(onBoardingPortalDAO.removeEmployee(employee)){
				modelAndView.setViewName("admin");
				return modelAndView;
			}else{
				modelAndView.setViewName("admin");
				return modelAndView;
			}
		
	}
	

	@RequestMapping("addgroup.htm")
	public ModelAndView addGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("group") Group group) 
	{
		HR user  =(HR) request.getSession().getAttribute("user");
		group.setHrId(user.getHrId());

		if (onBoardingPortalDAO.addGroup(group) != null) 
		{
			ModelAndView modelAndView = new ModelAndView();
			return preAddEmployeeToGroup(request, response, map);
		} else {
			ModelAndView modelAndView = new ModelAndView();
			map.addAttribute("opt", "all");
			modelAndView.setViewName("hr");
			return modelAndView;
		}

	}

	@RequestMapping("addmessage.htm")
	public ModelAndView addMessage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("message") Message message) 
	{
		message.setGroupId(1);
		message.setMsgTime(new java.sql.Date(0));
		message.setSubject("sample");
		if (onBoardingPortalDAO.addMessage(message)) {
			ModelAndView modelAndView = new ModelAndView();
			map.addAttribute("opt","all");
			modelAndView.setViewName("hr");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView();
			map.addAttribute("opt","all");
			modelAndView.setViewName("hr");
			return modelAndView;
		}

	}

	@RequestMapping("updateEmpProfile.htm")
	public ModelAndView updateProfileOfEmployee(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("currentEmployee") Employee employee) {

		if (onBoardingPortalDAO.updateEmployee(employee)) 
		{
			ModelAndView modelAndView = new ModelAndView();
			HttpSession session = request.getSession();
			session.setAttribute("user", employee);
			map.addAttribute("opt","all");
			modelAndView.setViewName("employee");
			return modelAndView;
		} 
		else 
		{
			ModelAndView modelAndView = new ModelAndView();
			map.addAttribute("opt","all");
			modelAndView.setViewName("employee");
			return modelAndView;
		}

	}

	@RequestMapping("")
	public ModelAndView updateProfileOfHR(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		if (onBoardingPortalDAO.updateHr(hr)) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("");
			return modelAndView;
		}

	}


	@RequestMapping("")
	public ModelAndView generatePassword(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("") HR hr) {
		return null;
	}

	

	@RequestMapping("preaddgroup.htm")
	public ModelAndView preAddGroup(HttpServletRequest request,
			HttpServletResponse response, ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		Group grp = new Group();
		map.addAttribute("group", grp);
		map.addAttribute("opt", "add_group");
		modelAndView.setViewName("hr");
		return modelAndView;
	}
	
	@RequestMapping("predeletegroup.htm")
	public ModelAndView preRemoveGroup(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) 
	{
		ModelAndView modelAndView = new ModelAndView();
		Group grp = new Group();
		map.addAttribute("group", grp);
		map.addAttribute("opt", "delete_group");
		modelAndView.setViewName("hr");
		return modelAndView;
	}
	
	@RequestMapping("deletegroup.htm")
	public ModelAndView removeGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("group") Group group) 
	{

		/*if(onBoardingPortalDAO.removeGroup(group))
		{
			ModelAndView modelAndView = new ModelAndView();
			Group grp = new Group();
			map.addAttribute("opt", "delete_group");
			modelAndView.setViewName("hr");
			return modelAndView;
		}*/
		ModelAndView modelAndView = new ModelAndView();
		map.addAttribute("opt", "all");
		modelAndView.setViewName("hr");
		return modelAndView;
	}

	@RequestMapping("newSession.htm")
	public ModelAndView newSession(HttpServletRequest request,
			HttpServletResponse response, ModelMap map) {

		ModelAndView modelAndView = new ModelAndView();

		User user = new User();
		map.addAttribute("user", user);
		System.out.println("Passing user");
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping("preaddemployee.htm")
	public ModelAndView preAddEmployeeToGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map) 
	{

		ModelAndView modelAndView = new ModelAndView();
		Group grp = new Group();
		Employee emp = new Employee();
		EmployeeGroup empGrp = new EmployeeGroup();
		empGrp.setEmployee(emp);
		empGrp.setGroup(grp);
		map.addAttribute("employeegrp",empGrp);
		map.addAttribute("opt", "add_emp");
		modelAndView.setViewName("hr");
		return modelAndView;
	}
	
	@RequestMapping("addemptogrp.htm")
	public ModelAndView addEmployeeToGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map,@ModelAttribute("employeegrp") EmployeeGroup empGrp ) {

		ModelAndView modelAndView = new ModelAndView();
		EmployeeGroupRequest employeeGroupRequest = new EmployeeGroupRequest();
		employeeGroupRequest.setEmployee(empGrp.getEmployee());
		employeeGroupRequest.setGroup(empGrp.getGroup());
		onBoardingPortalDAO.addEmployeeGroup(employeeGroupRequest);
		return preAddEmployeeToGroup(request, response, map);
	}

	@RequestMapping("predeleteemployee.htm")
	public ModelAndView preRemoveEmployeeFromGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map) 
	{
		ModelAndView modelAndView = new ModelAndView();
		Group grp = new Group();
		Employee emp = new Employee();
		EmployeeGroupRequest empGrp = new EmployeeGroupRequest();
		empGrp.setEmployee(emp);
		empGrp.setGroup(grp);
		map.addAttribute("employeegrp",empGrp);
		map.addAttribute("opt", "remove_emp");
		modelAndView.setViewName("hr");
		return modelAndView;
	}
	
	@RequestMapping("removegroup.htm")
	public ModelAndView removeEmployeeFromGroup(HttpServletRequest request,
			HttpServletResponse response,ModelMap map,@ModelAttribute("employeegrp") EmployeeGroupRequest empgrp) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if(onBoardingPortalDAO.removeEmployeeGroup(empgrp))
		{
			map.addAttribute("opt", "all");
			modelAndView.setViewName("hr");
		}
		else
		{

			map.addAttribute("opt", "all");
			modelAndView.setViewName("hr");
		}
		return modelAndView;
	}

	@RequestMapping("removepost.htm")
	public ModelAndView removeMessage(HttpServletRequest request,
			HttpServletResponse response,ModelMap map, @ModelAttribute("message") Message message) {
		// TODO Auto-generated method stub

		
		if (onBoardingPortalDAO.removeMessage(message)) 
		{
			return getPostsForHr(request, response, null, map);
		} 
		else 
		{
			return getPostsForHr(request, response, null, map);
		}

	}
	
	@RequestMapping("hrallposts.htm")
	public ModelAndView getAllPostsForHr(HttpServletRequest request,
			HttpServletResponse response, HrMessagesRequest hrMessageRequest, ModelMap map) {

		ModelAndView modelAndView = new ModelAndView();
		hrMessageRequest = new HrMessagesRequest();
		hrMessageRequest.setPageNumber(1);
		HttpSession session = request.getSession();
		HR currentHr = (HR) session.getAttribute("user");
		hrMessageRequest.setHr(currentHr);
		hrMessageRequest.setGroup(null);
		MessagesResponse messageResponse = onBoardingPortalDAO.postForHr(hrMessageRequest);
		ArrayList<MessageGroup> messages = getMessageGroupList(messageResponse);
		int currentPage = 1;
		int noOfPages = messages.size()/5;
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		map.addAttribute("currentPage", currentPage);
		map.addAttribute("noOfPages", noOfPages);
		map.addAttribute("messages", messages);
		map.addAttribute("opt","all");
		modelAndView.setViewName("hr");
		return modelAndView;
	}

	@RequestMapping("empmsgfromgrp.htm")
	public ModelAndView getPostsForEmployee(HttpServletRequest request,
			HttpServletResponse response,
			EmployeeMessagesRequest employeeMessagesRequest, ModelMap map) {

		ModelAndView modelAndView = new ModelAndView();
		int grpId = Integer.parseInt(request.getParameter("grpId"));
		Group postGroup = new Group();
		postGroup.setGroupId(grpId);
		employeeMessagesRequest = new EmployeeMessagesRequest();
		employeeMessagesRequest.setGroup(postGroup);
		HttpSession currSession = request.getSession();
		Employee currentEmp = (Employee) currSession.getAttribute("user");
		employeeMessagesRequest.setEmployee(currentEmp);
		MessagesResponse messageResponse = onBoardingPortalDAO.postForEmployee(employeeMessagesRequest);
		ArrayList<MessageGroup> messages = getMessageGroupList(messageResponse);
		int currentPage = 1;
		int noOfPages = messages.size()/5;
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		map.addAttribute("grpName", postGroup.getGroupName());
		map.addAttribute("currentPage", currentPage);
		map.addAttribute("noOfPages", noOfPages);
		map.addAttribute("messages", messages);
		map.addAttribute("opt", "group");
		modelAndView.setViewName("employee");
		
		return modelAndView;
	}
	
	
	@RequestMapping("hrmsgfromgrp.htm")
	public ModelAndView getPostsForHr(HttpServletRequest request,
			HttpServletResponse response,
			HrMessagesRequest hrMessagesRequest, ModelMap map) {

		ModelAndView modelAndView = new ModelAndView();
		int grpId = Integer.parseInt(request.getParameter("grpId"));
		Group postGroup = new Group();
		postGroup.setGroupId(grpId);
		hrMessagesRequest = new HrMessagesRequest();
		hrMessagesRequest.setGroup(postGroup);
		HttpSession currSession = request.getSession();
		HR currentHr = (HR) currSession.getAttribute("user");
		hrMessagesRequest.setHr(currentHr);
		MessagesResponse messageResponse = onBoardingPortalDAO.postForHr(hrMessagesRequest);
		ArrayList<MessageGroup> messages = getMessageGroupList(messageResponse);
		int currentPage = 1;
		int noOfPages = messages.size()/5;
		if(request.getParameter("currentPage")!=null)
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		map.addAttribute("grpName", postGroup.getGroupName());
		map.addAttribute("currentPage", currentPage);
		map.addAttribute("noOfPages", noOfPages);
		map.addAttribute("messages", messages);
		map.addAttribute("opt", "group");
		modelAndView.setViewName("hr");
		
		return modelAndView;
	}

	public ModelAndView getAllEmployeesOfGroup(HttpServletRequest request,
			HttpServletResponse response, Group group) {

		return null;
	}
	
	public MessagesResponse getAllPosts(Employee emp)
	{
		EmployeeMessagesRequest employeeMessagesRequest = new EmployeeMessagesRequest();
		employeeMessagesRequest.setGroup(null);
		employeeMessagesRequest.setEmployee(emp);
		MessagesResponse messageResponse = onBoardingPortalDAO.postForEmployee(employeeMessagesRequest);
		return messageResponse;
	}
	
	
	public ArrayList<MessageGroup> getMessageGroupList(MessagesResponse msgResponse)
	{
		ArrayList<MessageGroup> result = new ArrayList<MessageGroup>();
		Iterator<Message> itMsg = msgResponse.getMessagesList().iterator();
		Iterator<Group> itGrp = msgResponse.getGroupsList().iterator();
		while(itMsg.hasNext() && itGrp.hasNext())
		{
			MessageGroup msgGrp = new MessageGroup();
			msgGrp.setGroup(itGrp.next());
			msgGrp.setMessage(itMsg.next());
			result.add(msgGrp);
		}
		return result;
	}
	
	@RequestMapping("preaddpost.htm")
	public ModelAndView preAddPost(HttpServletRequest request,
			HttpServletResponse response, ModelMap map)
	{
		ModelAndView modelAndView = new ModelAndView();
		Message message = new Message();
		map.addAttribute("message", message);
		map.addAttribute("opt", "add_post");
		modelAndView.setViewName("hr");
		return modelAndView;
	}
}
