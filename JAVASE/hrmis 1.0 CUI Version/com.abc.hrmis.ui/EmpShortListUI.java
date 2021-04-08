/**
 * 
 */
package com.abc.hrmis.ui;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;

/**
 * 
 * 员工信息部分属性列表界面
 * @author 15159
 *
 */
public class EmpShortListUI implements BaseUI {

	private static final String LIST_INFO;	
	
	static {
		StringBuilder sb = new StringBuilder();
		
//		SysFileUtils.readInfo();
//		SysFileUtils.saveInfo();
		
		for(Employee em:SysFileUtils.list)
			sb.append(String.valueOf(em.toShortString())+"\n");
		
		LIST_INFO = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		showShortListInfo();
		SysUtils.pause("\nPress Enter to continue...");
	}

	/**
	 * 打印列表信息
	 */
	private void showShortListInfo() {
		System.out.print(LIST_INFO);
	}

}
