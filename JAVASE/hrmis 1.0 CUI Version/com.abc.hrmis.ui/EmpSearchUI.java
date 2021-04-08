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
 * 员工信息查询界面
 * 
 * @author 15159
 *
 */
public class EmpSearchUI implements BaseUI {

	private static final String SEARCH_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Enter keyword:");
		
		SEARCH_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showSearchListInfo();
		
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		SysUtils.searchByName(name);
		
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showSearchListInfo() {
		System.out.print(SEARCH_INFO);
	}

}
