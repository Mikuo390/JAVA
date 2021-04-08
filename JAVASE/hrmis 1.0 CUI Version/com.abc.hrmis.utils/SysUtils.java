/**
 * 
 */
package com.abc.hrmis.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.exception.BlankEntryException;
import com.abc.hrmis.ui.BaseUI;
import com.abc.hrmis.ui.EmpAddUI;
import com.abc.hrmis.ui.EmpRemoveUI;



/**
 * 
 * 系统工具类
 * 
 * @author 15159
 *
 */
public class SysUtils {
	
	/**
	 * 获得录入，不允许空输入
	 * @return
	 */
	public static String getEntry() {
		return getEntry(false);
	}

	/**
	 * 获得录入
	 * @param allowBlank 是否允许空输入
	 * @return
	 */
	public static String getEntry(boolean allowBlank) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		
		try {
			entry=reader.readLine();
			if(isBlankStr(entry) && !allowBlank)
				throw new BlankEntryException();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return entry;
	}
	
	/**
	 * 空串检测
	 * @param str
	 * @return
	 */
	public static boolean isBlankStr(String str) {
		return str==null || str.trim().length()==0;
	}
	
	/**
	 * 暂停
	 */
	public static void pause() {
		SysUtils.getEntry(true);
	}
	
	/**
	 * 带提升的暂停
	 * @param msg 提示消息
	 */
	public static void pause(String msg) {
		System.out.print(msg);
		pause();
	}
	
	/**
	 * 启动UI界面
	 * @param ui
	 */
	public static void runUI(BaseUI ui) {
		ui.setup();
	}
	
	/**
	 * 名字顺序排序
	 */
	public static void sortByName() {
		Collections.sort(SysFileUtils.list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getLastname().compareTo(o2.getLastname());
			}		
		});
	}
	
	/**
	 * 搜寻
	 */
	public static void searchByName(String info) {
		if(SysFileUtils.list.size()>0) {//集合内容存在
			boolean isFind = false;
			for(int i=0;i<SysFileUtils.list.size();i++) {
				Employee em = SysFileUtils.list.get(i);					
				if(info.equalsIgnoreCase(em.getLastname())  
					|| info.equalsIgnoreCase(em.getFirstname()) 
					|| info.equalsIgnoreCase(em.getInitial())
					|| info.equalsIgnoreCase(String.valueOf(em.getDeptNo()))
					|| info.equalsIgnoreCase(em.getTelephoneCode())
					|| info.equalsIgnoreCase(em.getPayrollNo())
					|| info.equalsIgnoreCase(em.getJobTitle())
					|| info.equalsIgnoreCase(em.getHiringDate())) {				
					isFind=true;
					System.out.println(String.valueOf(em.toString()));
				}

			}if(isFind==false) {
				System.out.println("Keyword – Monks - not found");
			}
		}
	}
	
	public static void addInfo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter employee 3 digit payroll number: ");
		String payrollNo = sc.next();
		
		System.out.print("Enter Phone Number (02-12345678): ");
		String telephoneCode = sc.next();
		
		System.out.print("Enter Last Name: ");
		String lastname = sc.next();
		
		System.out.print("Enter First Name: ");
		String firstname = sc.next();
		
		System.out.print("Enter Middle Init: ");
		String initial = sc.next();
		
		System.out.print("Enter Dept #: ");
		String jobTitle = sc.next();
		
		System.out.print("Enter Job Title: ");
		int deptNo = sc.nextInt();
		
		System.out.print("Enter Date Hired (dd-mm-yyyy): ");
		String hiringDate = sc.next();
		
		System.out.println("\n");
		
		SysFileUtils.list.add(new Employee(payrollNo, telephoneCode, lastname, firstname, initial, deptNo, jobTitle, hiringDate));
		SysFileUtils.saveInfo();//保存至文件
		System.out.println("Record Saved");
		
		System.out.print("Add another employee record? (y)es or (n)o,");
		char select = sc.next().charAt(0);
		continueAddInfo(select);
	}
	
	/**
	 * 是否继续添加
	 * @param select 用户输入的选择
	 */
	public static void continueAddInfo(char select) {
		if(select=='y') {
			SysUtils.runUI(new EmpAddUI());
		}else {
			return;
		}
	}
	
	/**
	 * 删除
	 */
	public static void deleteInfo(String payrollNo) {
		Scanner sc = new Scanner(System.in);
		boolean isFind = false;
		if(SysFileUtils.list.size()>0) {//集合内容存在
			for(int i=0;i<SysFileUtils.list.size();i++) {
				Employee em = SysFileUtils.list.get(i);					
				if(payrollNo.equals(em.getPayrollNo())) {
					System.out.println(SysFileUtils.list.get(i));
					SysFileUtils.list.remove(i);//移除
					isFind=true;
					break;
				}	
			}
			SysFileUtils.saveInfo();//保存至文件
			if(isFind==false) {
				System.out.println("Employee record for "+payrollNo+" not found!");		
			}

		}
		System.out.print("Delete another? (y)es or (n)o,");
		char select = sc.next().charAt(0);
		continueDeleteInfo(select);
	}
	
	/**
	 * 是否继续删除
	 * @param select 用户输入的选择
	 */
	public static void continueDeleteInfo(char select) {
		if(select=='y') {
			SysUtils.runUI(new EmpRemoveUI());
		}else {
			return;
		}
	}
}
