/**
 * 
 */
package com.abc.hrmis.ui;

import java.util.Scanner;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;

/**
 * 
 * 员工信息新增界面
 * 
 * @author 15159
 *
 */
public class EmpAddUI implements BaseUI {

	private static final String ADD_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Adfaith Consulting – Employee Records:\n")
		  .append("======================================\n\n")
		  .append("Employee Record Additions:\n\n")
		  .append("Enter the following details of the new employee:\n\n")
		  .append("Employee 3 digit payroll number:\n")
		  .append("Phone Number\n")
		  .append("Last Name\n")
		  .append("First Name\n")
		  .append("Middle Init\n")
		  .append("Dept #\n")
		  .append("Job Title\n")
		  .append("Date Hired\n");
		
		ADD_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showAddListInfo();
				
		SysUtils.addInfo();
		
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showAddListInfo() {
		System.out.print(ADD_INFO);
	}

}
