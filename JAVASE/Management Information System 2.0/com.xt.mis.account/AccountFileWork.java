/**
 * 
 */
package com.xt.mis.account;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.menu.RegisterMenu;

import sun.misc.ObjectInputFilter;


/**
 * @author 15159
 *
 */
public class AccountFileWork {

	static File accoutFile = new File("d:/Acount.bin");
	public static ArrayList<Account> accountlist = new ArrayList<Account>();
	
	//第一次加载写入账号文件
	public static void savefirst() {
		if(accoutFile.length()==0) {
			//创建账号文件
			try {
				accoutFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//写入操作
			FileOutputStream fos = null;//创建文件读取流
			ObjectOutputStream oos = null;			
			try {
				fos = new FileOutputStream(accoutFile,false);
				oos = new ObjectOutputStream(fos);
				//将账号文件写入
				oos.writeObject(new Account("admin","666666"));			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {	
				try {
					fos.flush();
					fos.close();
					oos.flush();
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//保存
	public static void saveAccout(){
		FileOutputStream fos = null;//创建文件读取流
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(accoutFile,false);
			//判断是否第一次写入
			if(accoutFile.length()<1) {
				oos = new ObjectOutputStream(fos);//
			}
			else {
				oos = new MyObjectOutputStream(fos);//
			}
			//将账号文件写入
			for(int i=0;i<accountlist.size();i++) {
				oos.writeObject(accountlist.get(i));
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	
			try {
				fos.flush();
				fos.close();
				oos.flush();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//读取账号文件
	public static void readAccout() {
		Account ac = new Account();
		ObjectInputStream ois = null;
		accountlist.clear();//防止多次点击导致表内数据叠加
		try {
			//读取文件	
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(accoutFile)));
			while((ac=(Account)ois.readObject())!=null) {
				accountlist.add(ac);//将文件内的账号数据存到数组中
			}
		} catch (EOFException e){
			System.out.println("文件读取完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
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


//重写writeStreamHeader()
class MyObjectOutputStream extends ObjectOutputStream{

	public MyObjectOutputStream() throws IOException
	{
		super();
	}
	
	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	public void writeStreamHeader() throws IOException{
		return;
	}
}
