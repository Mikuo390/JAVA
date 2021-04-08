/**
 * 
 */
package com.abc.hrmis.ui;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;

/**
 * 
 * 员工信息部分属性格式化排序输出界面
 * 
 * @author 15159
 *
 */
public class EmpFormattedShortListUI implements BaseUI {

	private static final String LIST_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
//		SysFileUtils.readInfo();
//		SysFileUtils.saveInfo();
		SysUtils.sortByName();
		for(Employee em:SysFileUtils.list)
			sb.append(String.valueOf(em.toFormattedShortString())+"\n");
		
		LIST_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showFormattedShortListInfo();
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showFormattedShortListInfo() {
		System.out.print(LIST_INFO);
	}

}
