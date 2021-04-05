/**
 * 
 */
package com.xt.mis;

import java.io.Serializable;

/**
 * @author 15159
 *
 */
public class EmployeeInfo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	/**工号*/	
	private int employeePayrollNumber;
	
	/**电话*/	
	private String teleNumber;
	
	/**名字*/	
	private String lastName;
	private String firstName;	
	private String initialName;
	
	/**部门号*/	
	private int departmentNumber;
	
	/**工作类型*/	
	private String jobTitle;

	/**入职时间*/	
	private String dateOfHiring;
	
	@Override
	public String toString() {
		return employeePayrollNumber + ":" + 
				teleNumber + ":" + 
				lastName + ":" + 
				firstName + ":" + 
				initialName + ":" + 
				departmentNumber + ":" + 
				jobTitle + ":" + 
				dateOfHiring;
	}
	
	public String toString2() {
		return String.format("%-12s%-12s%-5s %-5d %-12s  %-5d %-20s %-10s", 
				lastName,firstName,initialName,
				employeePayrollNumber,teleNumber,				
				departmentNumber,jobTitle,dateOfHiring);
	}
	
	public String toString3() {
		return lastName + "," + 
				firstName + "," + 
				teleNumber;			
	}
	
	public String toString4() {
		return String.format("%-12s%-12s %-12s", 
				lastName,firstName,teleNumber);
	}
	
//	public int compareTo(Object o) {
//		EmployeeInfo em = (EmployeeInfo)o;
//		if(Integer.parseInt(lastName)<Integer.parseInt(em.getLastName()))
//			return -1;
//		else if(Integer.parseInt(lastName)>Integer.parseInt(em.getLastName()))
//			return -1;
//		return 0;
//	}

	public EmployeeInfo(int employeePayrollNumber, String teleNumber, String lastName, String firstName,
			String initialName, int departmentNumber, String jobTitle, String dateOfHiring) {
		super();
		this.employeePayrollNumber = employeePayrollNumber;
		this.teleNumber = teleNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.initialName = initialName;
		this.departmentNumber = departmentNumber;
		this.jobTitle = jobTitle;
		this.dateOfHiring = dateOfHiring;
	}
	

	public EmployeeInfo() {
		// TODO Auto-generated constructor stub
	}


	public int getEmployeePayrollNumber() {
		return employeePayrollNumber;
	}

	public void setEmployeePayrollNumber(int employeePayrollNumber) {
		this.employeePayrollNumber = employeePayrollNumber;
	}

	public String getTeleNumber() {
		return teleNumber;
	}

	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInitialName() {
		return initialName;
	}

	public void setInitialName(String initialName) {
		this.initialName = initialName;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDateOfHiring() {
		return dateOfHiring;
	}

	public void setDateOfHiring(String dateOfHiring) {
		this.dateOfHiring = dateOfHiring;
	}
	
	
}
