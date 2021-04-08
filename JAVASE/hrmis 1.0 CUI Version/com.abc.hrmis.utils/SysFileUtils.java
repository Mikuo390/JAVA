/**
 * 
 */
package com.abc.hrmis.utils;

import com.abc.hrmis.domain.*;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author 15159
 *
 */
public class SysFileUtils {

	public static File file = new File("d:/records.txt");
	static Employee em = new Employee();
	
	public static ArrayList<Employee> list = new ArrayList<Employee>();

	/**
	 * 检测文件是否存在
	 * @param file 传入的文件引用变量
	 */
	public static void checkFile(File file) {
		if(!file.exists()) {
			System.out.println("Required file – records, does not exist.");
			System.exit(0);//退出程序
		}
	}
	
		
	/**
	 * 从文件中读取员工信息
	 */
	public static void readInfo() {
		ObjectInputStream ois = null;//输入流
		list.clear();//防止多次输出导致表内数据叠加
		try {
			ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			while((em=(Employee)ois.readObject())!= null){
				list.add(em);//将文件内的类数据存到数组中
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
	
	/**
	 * 将数据保存在文件中
	 */
	public static void saveInfo() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file,false));
			for(int i=0;i<list.size();i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
