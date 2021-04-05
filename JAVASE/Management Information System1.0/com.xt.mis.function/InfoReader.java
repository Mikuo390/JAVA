/**
 * 
 */
package com.xt.mis.function;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.menu.*;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.xt.mis.EmployeeInfo;
/**
 * @author 15159
 *
 */
public class InfoReader {
	
	//用于存放数据
	public static ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
	
	public static void readInfo() {
		EmployeeInfo em = new EmployeeInfo();
		File file = new File("d:/misdata.bin");	
		ObjectInputStream ois = null;		
		list.clear();//防止多次点击导致表内数据叠加
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			while((em=(EmployeeInfo)ois.readObject())!=null) {
				list.add(em);//将文件内的类数据存到数组中
//				FunctionMenu.infoWindow.append(String.valueOf(em.toString())+"\n");
//				System.out.println(em);				
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e){
			System.out.println("文件读取完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
