/**
 * 
 */
package com.abc.hrmis.domain;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author 15159
 *
 */
public class Employee extends ValueObject implements Comparable<Employee>,Serializable{

	/** 工号*/
	private String payrollNo;
	/** 电话号码*/
	private String telephoneCode;
	/** 名字*/
	private String lastname;
	private String firstname;
	private String initial;
	/** 部门编号*/
	private int deptNo;
	/** 职务*/
	private String jobTitle;
	/** 雇佣时间*/
	private String hiringDate;
	

	

	public Employee() {
		super();
	}

	public Employee(String payrollNo, String telephoneCode, String lastname, String firstname, String initial,
			int deptNo, String jobTitle, String hiringDate) {
		super();
		this.payrollNo = payrollNo;
		this.telephoneCode = telephoneCode;
		this.lastname = lastname;
		this.firstname = firstname;
		this.initial = initial;
		this.deptNo = deptNo;
		this.jobTitle = jobTitle;
		this.hiringDate = hiringDate;
	}

	public String toString() {
		return payrollNo + ":" + 
				telephoneCode + ":" + 
				lastname + ":" + 
				firstname + ":" + 
				initial + ":" + 
				deptNo + ":" + 
				jobTitle + ":" + 
				hiringDate;
	}
	
	public String toFormattedString() {
		return String.format("%-12s%-12s%-5s %-5s %-12s  %-5d %-20s %-10s", 
				lastname,firstname,initial,
				payrollNo,telephoneCode,				
				deptNo,jobTitle,hiringDate);
	}
	
	public String toShortString() {
		return lastname + "," + 
				firstname + "," + 
				telephoneCode;			
	}
	
	public String toFormattedShortString() {
		return String.format("%-12s%-12s %-12s", 
				lastname,firstname,telephoneCode);
	}
	
	@Override
	public int compareTo(Employee o) {
		return this.lastname.compareTo(o.lastname);
	}
	
	public String getPayrollNo() {
		return payrollNo;
	}
	public void setPayrollNo(String payrollNo) {
		this.payrollNo = payrollNo;
	}
	public String getTelephoneCode() {
		return telephoneCode;
	}
	public void setTelephoneCode(String telephoneCode) {
		this.telephoneCode = telephoneCode;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(String hiringDate) {
		this.hiringDate = hiringDate;
	}

	
}
