/**
 * 
 */
package com.abc.hrmis.ui;

import java.io.File;

import com.abc.hrmis.exception.BlankEntryException;
import com.abc.hrmis.utils.SysFileUtils;
import com.abc.hrmis.utils.SysUtils;

/**
 * 
 * 主菜单界面
 * 
 * @author 15159
 *
 */
public class MainMenuUI implements BaseUI {

	//私有常量
	private static final String MENU_INFO;
	
	//实例属性的复杂初始化用构造方法
	//静态属性的复杂初始化用静态块
	
	static{//静态块——给静态属性进行复杂初始化
		//StringBuilder进行拼接
		StringBuilder sb = new StringBuilder();
		
		sb.append("讯通科技 - Employee Information - Main Menu\n")
		  .append("=====================================================\n\n")
		  .append("1 - Print All Current Records\n")
		  .append("2 – Print All Current Records (formatted)\n")
		  .append("3 – Print Names and Phone Numbers\n")
		  .append("4 – Print Names and Phone Numbers (formatted)\n")
		  .append("5 - Search for specific Record(s)\n")
		  .append("6 - Add New Records\n")
		  .append("7 – Delete Records\n\n")
		  .append("Q - Quit\n\n")
		  .append("Your Selection:");
		
		MENU_INFO = sb.toString();
		SysFileUtils.checkFile(new File("d:/records.txt"));
		SysFileUtils.readInfo();//加载文件内的数据
//		SysFileUtils.saveInfo();
	}

	
	
	/* (non-Javadoc)
	 * @see com.abc.hrmis.ui.BaseUI#setup()
	 */
	@Override
	public void setup() {
		
		boolean isContinued = true;
		String entry = null;
		while(isContinued) {
			
			showMenu();
			try {
				entry = SysUtils.getEntry();
				char choice = entry.toUpperCase().charAt(0);//获取输入的第一个字符串
				
				switch(choice) {
					case'1':
						SysUtils.runUI(new EmpListUI());
						break;
					case'2':
						SysUtils.runUI(new EmpFormattedListUI());
						break;
					case'3':
						SysUtils.runUI(new EmpShortListUI());
						break;
					case'4':
						SysUtils.runUI(new EmpFormattedShortListUI());
						break;
					case'5':
						SysUtils.runUI(new EmpSearchUI());
						break;
					case'6':
						SysUtils.runUI(new EmpAddUI());
						break;
					case'7':
						SysUtils.runUI(new EmpRemoveUI());
						break;
					case'Q':
						isContinued=false;
						break;
					default:
						SysUtils.pause("Invalid code! Press Enter to continue…");
				}
				
			} catch(BlankEntryException e) {
				SysUtils.pause("\nNo selection entered. Press Enter to continue…");
			}
		
		}
		
		System.out.println("\nThank you for using HRMIS v1.0! Bye!");

	}
	/**
	 * 打印菜单
	 */
	private void showMenu() {
		System.out.print(MENU_INFO);
	}

}
