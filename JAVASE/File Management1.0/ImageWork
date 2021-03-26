/**
 * 
 */
package com.abc.filemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 15159
 *
 */
public class ImageWork implements BasicFileWork{

	public static void ImaWork(File file) {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("图片文件已读入");
			System.out.println("——————————————");
			System.out.println("1.拷贝	2.删除");
			System.out.println("3.信息	0.退出");
			System.out.println("——————————————");
			System.out.print("请选择操作：");
			choice = sc.nextInt();
			
			if(choice == 0) break;
			switch (choice) {
			case 1:	new ImageWork().copyFile(file);
				break;
			case 2:	new ImageWork().deleteFile(file);
				break;	
			default:System.out.println("选择错误，请重新选择！！！");
				break;
			}
			
		}
	}
	
	/**
	 * 图片文件拷贝
	 */
	@Override
	public void copyFile(File file) {
		// TODO Auto-generated method stub
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(file.getAbsolutePath());
			fos = new FileOutputStream(file.getParentFile()+file.getName()+"_bak");
			
			byte[] buffer = new byte[1024];
			int size=0;
			
			while((size=fis.read(buffer))!=-1) {
				fos.write(buffer,0,size);
				System.out.println("已拷贝"+size+"B");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			fis.close();
			fos.flush();
			fos.close();
			} catch (IOException e) {
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
