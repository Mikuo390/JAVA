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
 * 员工信息的删除界面
 * 
 * @author 15159
 *
 */
public class EmpRemoveUI implements BaseUI {

	private static final String DELETE_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Adfaith Consulting – Employee Records:\n")
		  .append("======================================\n\n")
		  .append("Employee Record Deletion:\n\n")
		  .append("Enter employee’s 3 digit payroll number to enable file deletion:");
		
		DELETE_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showAddListInfo();
		Scanner sc = new Scanner(System.in);
		String payrollNo = sc.next();
		
		SysUtils.deleteInfo(payrollNo);
		
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showAddListInfo() {
		System.out.print(DELETE_INFO);
	}


}
