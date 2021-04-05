/**
 * 
 */
package com.xt.mis.function;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.menu.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 15159
 *
 */
public class Function {
	
	public static File FILE = new File("d:/misdata.bin");
	
	
	public static void checkFile() {
		if(!FILE.exists()) {
			new CreateMenu();			
		}
	}		
	
	//打印所有文件
	public static void printInfo() {
		FunctionMenu.infoWindow.setText("");
		checkFile();
//		InfoReader.readInfo();
		InfoReader1.readInfo();	
	}
	
	//打印所有文件(格式序)
	public static void printFormattedInfo() {
		FunctionMenu.infoWindow.setText("");
		checkFile();
		Collections.sort(InfoReader.list, new sortName());
		InfoReader2.readInfo2();		
	}
	
	//打印名字和电话
	public static void printNameAndTeleInfo() {
		FunctionMenu.infoWindow.setText("");
		checkFile();
//		InfoReader.readInfo();
		InfoReader3.readInfo3();
		
	}
	//打印名字和电话(格式排序)
	public static void printFormattedNameAndTeleInfo() {
		FunctionMenu.infoWindow.setText("");
		checkFile();
		Collections.sort(InfoReader.list, new sortName());
		InfoReader4.readInfo4();
		
	}
	
	public static void searchInfo() {
		new SearchInfoMenu();
	}
	
	public static void addInfo() {
//		FunctionMenu.infoWindow.setText("");
//		checkFile();
		new AddInfoMenu();//添加信息窗口
	}
	
	public static void deleteInfo() {
//		FunctionMenu.infoWindow.setText("");
//		checkFile();
		new DeleteMenu();//删除信息窗口
	}
	
}

class sortName implements Comparator<EmployeeInfo>{
	@Override
	public int compare(EmployeeInfo o1, EmployeeInfo o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}
}
