/**
 * 
 */
package com.abc.filemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author 15159
 *
 */
public class TXTWork extends FileInfo implements BasicFileWork {

	public static void TxtFileWork(File file){
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			
			System.out.println("文本文件已读入");
			System.out.println("——————————————");
			System.out.println("1.续写	2.重写");
			System.out.println("3.拷贝	4.清空");
			System.out.println("5.信息	0.退出");
			System.out.println("——————————————");
			System.out.print("请选择操作：");
			choice = sc.nextInt();
			
			if(choice == 0) break;
			switch (choice) {
			case 1:	continueWrite(file);
				break;
			case 2:	rewrite(file);
				break;
			case 3:	new TXTWork().copyFile(file);
				break;
			case 4:	new TXTWork().deleteFile(file);
				break;	
			case 5:	showInfo(file);;
				break;	
			default:System.out.println("选择错误，请重新选择！！！");
				break;
			}
		}
	}
	
	
	/**
	 * 续写文件函数
	 * @param file
	 */
	public static void continueWrite(File file) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = null;
		try {
			//追加写入
			writer = new PrintWriter(new FileOutputStream(file.getAbsolutePath(),true));
			String entry;//用于存储写入的段落
			
			System.out.println("————文本编辑器————");
			int lines=1;
			System.out.print("["+lines+"]");
			//读入多行
			while(!(entry = reader.readLine()).equalsIgnoreCase("END")) {
				writer.println(entry);
				lines++;
				System.out.print("["+lines+"]");
			}
			System.out.println("编写结束，总计["+(lines-1)+"]行");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}
	
	/**
	 * 重写文件函数
	 * @param file
	 */
	public static void rewrite(File file) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = null;
		try {
			//追加写入
			writer = new PrintWriter(new FileOutputStream(file.getAbsolutePath(),false));
			String entry;//用于存储写入的段落
			
			System.out.println("————文本编辑器————");
			int lines=1;
			System.out.print("["+lines+"]");
			//读入多行
			while(!(entry = reader.readLine()).equalsIgnoreCase("END")) {
				writer.println(entry);
				lines++;
				System.out.print("["+lines+"]");
			}
			System.out.println("编写结束，总计["+(lines-1)+"]行");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 文本文件拷贝
	 */
	@Override
	public void copyFile(File file) {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
			writer = new PrintWriter(new FileOutputStream(file.getParentFile()+file.getName()+"_bak"));
			
			String entry = null;
			int times = 0;
			while((entry=reader.readLine())!=null) {
				writer.println(entry);
				times++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("拷贝完成！");
	}


	@Override
	public void deleteFile(File file) {
		// TODO Auto-generated method stub
		file.delete();
		System.out.println("文件以删除!");
	}
	
	
	
	
}
