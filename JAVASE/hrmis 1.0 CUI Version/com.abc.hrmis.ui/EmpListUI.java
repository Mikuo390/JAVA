/**
 * 
 */
package com.abc.hrmis.ui;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;


/**
 * 
 *员工信息全属性列表界面
 * 
 * @author 15159
 *
 */
public class EmpListUI implements BaseUI {

	private static final String LIST_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
//		SysFileUtils.readInfo();
//		SysFileUtils.saveInfo();
		
		for(Employee em:SysFileUtils.list)
			sb.append(String.valueOf(em.toString())+"\n");
		
		LIST_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showListInfo();
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showListInfo() {
		System.out.print(LIST_INFO);
	}
	
}
