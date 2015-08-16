package DAO;

import requests.*;
import responses.*;
import Entities.*;


public interface OnBoardingPortalDAO 
{
	public boolean addEmployee(Employee employee);
	public boolean addHr(HR hr);
	public Group addGroup(Group group);
	public boolean addMessage(Message message);
	
	public boolean addEmployeeGroup(EmployeeGroupRequest empgrpreq);
	
	public boolean removeEmployee(Employee employee);
	public boolean removeGroup(Group group);
	public boolean removeEmployeeGroup(EmployeeGroupRequest empgrpreq);
	public boolean removeMessage(Message message);
	
	public Employee validateEmployee(Employee employee);
	public HR validateHr(HR hr);
	public Admin validateAdmin(Admin admin);

	public boolean updateEmployee(Employee employee);
	public boolean updateHr(HR hr);
	
	public MessagesResponse postForHr(HrMessagesRequest hrmsg);
	public MessagesResponse postForEmployee(EmployeeMessagesRequest empmsg);
	
	public  Group getAllEmpGrp(Group group);
	
}