/**
 * 
 */
package com.abc.filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 15159
 *
 */
public class FileWork{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String fileName;
		
		System.out.println("！！！欢迎使用文件操作系统！！！");
		System.out.print("请输入文件的路径名：》》》");
		fileName = sc.nextLine();
		File file = new File(fileName);
		System.out.println("绝对路径："+file.getAbsolutePath());
//		System.out.println("文件位置："+file.getParent());
//		System.out.println(file.getParentFile()+file.getName()+"_bak");
		checkFile(file);

	}
	
	public static void UI() {
		System.out.println("————————————————————————");
	}
	
	/**
	 * 检查文件是否存在，并做出初步判断
	 * @param file 输入的文件
	 */
	public static void checkFile(File file) {
		
		Scanner sc = new Scanner(System.in);
		
		if(file.exists()) {		
			System.out.println("文件存在！");
			
			if(file.isFile()) {
				System.out.println("您所输入的文件是一个文件");
				checkFileType(file);
			}
			else if(file.isDirectory()) {
				System.out.println("您所输入的文件的一个目录");
			}
			else {
				System.out.println("未知文件");
			}
		}
		else if(!file.exists()) {
			System.out.println("您所输入的文件不存在");
			System.out.println("是否要创建文件？(y/n)");
			String choice = sc.nextLine();
			if(choice.charAt(0)=='y' || choice.charAt(0)=='Y') {
//				System.out.println("请输入要创建的文件路径名");
				try {
					file.createNewFile();
					System.out.println("文件创建完成！");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					checkFile(file);
				}
			}
		}
		
	}
	
	/**
	 * 判断文件的具体类型
	 * @param file
	 */
	public static void checkFileType(File file) {
		
		if(file.getName().endsWith(".txt")) {
			TXTWork.TxtFileWork(file);
		}
		else if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) {
			
			ImageWork.ImaWork(file);
		}
		
	}

}
