/**
 * 
 */
package com.abc.hrmis;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.ui.BaseUI;
import com.abc.hrmis.ui.MainMenuUI;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;

/**
 * @author 15159
 *
 */
public class SysLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SysFileUtils.list.add(new Employee("112", "02-99893878", "Brown", "Sarah", "B", 12, "Electrician", "09-02-1992"));	
//		SysFileUtils.list.add(new Employee("111", "02-98781999", "Williams", "Nick", "T", 35, "Computer Officer", "14-10-2000"));
		
		SysUtils.runUI(new MainMenuUI());

	}

}
