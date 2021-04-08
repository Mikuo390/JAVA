/**
 * 
 */
package com.abc.hrmis.ui;

import java.util.Collections;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;

/**
 * 
 * 员工信息全属性格式化输出列表界面
 * @author 15159
 *
 */
public class EmpFormattedListUI implements BaseUI {

	private static final String LIST_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
//		SysFileUtils.readInfo();
//		SysFileUtils.saveInfo();
		SysUtils.sortByName();
		for(Employee em:SysFileUtils.list)
			sb.append(String.valueOf(em.toFormattedString())+"\n");
		
		LIST_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showFormattedListInfo();
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showFormattedListInfo() {
		System.out.print(LIST_INFO);
	}

}
