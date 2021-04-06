/**
 * 
 */
package com.xt.mis.function;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.menu.AddInfoMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 15159
 *
 */
public class InfoSaver {

	public static void saveInfo() {
		
		File file = new File("d:/misdata.bin");	
		
		//测试创建表存储对象
//		ArrayList<EmployeeInfo> list = new ArrayList<EmployeeInfo>();	
//		list.add(new EmployeeInfo(111, "02-98781999", "Williams", "Nick", "T", 35, "Computer Officer", "14-10-2000"));
//		list.add(new EmployeeInfo(112, "02-99893878", "Brown", "Sarah", "B", 12, "Electrician", "09-02-1992"));		
			
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;//父类引用变量指向子类对象
		try {
			fos = new FileOutputStream(file,false);	
			//判断是否第一次写入
			if(file.length()<1) {
				oos = new ObjectOutputStream(fos);
			}
			else {
				oos = new MyObjectOutputStream(fos);
			}
			//多次写入
			for(int i=0;i<InfoReader.list.size();i++) {
				oos.writeObject(InfoReader.list.get(i));
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
