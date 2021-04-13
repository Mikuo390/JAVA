/**
 * 
 */
package com.xt.mis.menu;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.function.Function;
import com.xt.mis.function.InfoReader;

/**
 * @author 15159
 *
 */
public class AddInfoMenu extends JFrame implements ActionListener{
	
	JLabel jl = new JLabel("添加员工信息");
	
	//编号
	public JLabel eNumber = new JLabel("员工编号");
	public JTextField eNumberText = new JTextField();
	//电话
	public JLabel teleNumber = new JLabel("员工电话");
	public JTextField teleNumberText = new JTextField();
	//名字
	public JLabel lastName = new JLabel("姓氏");
	public JTextField lastNameText = new JTextField();
	public JLabel firstName = new JLabel("名字");
	public JTextField firstNameText = new JTextField();
	public JLabel initialName = new JLabel("中间名");
	public JTextField initialNameText = new JTextField();
	//部门号
	public JLabel deNumber = new JLabel("部门号");
	public JTextField deNumberText = new JTextField();
	//工作类型
	public JLabel jobTitle = new JLabel("工作类型");
	public JTextField jobTitleText = new JTextField();
	//聘用日期
	public JLabel date = new JLabel("聘用日期");
	public JTextField dateText = new JTextField();
	
	//按钮
	public JButton addBtn = new JButton("添加");
	public JButton clearBtn = new JButton("清空");
	public JButton cancelBtn = new JButton("取消");	
	
	public AddInfoMenu() {	
		this.setTitle("添加员工信息");//标题
		this.setBounds(1000, 500, 300, 500);
		this.setLayout(null);
		
		jl.setBounds(100, 10, 80, 30);
		this.add(jl);
		//员工号
		eNumber.setBounds(50, 50, 80, 30);	
		this.add(eNumber);
		eNumberText.setBounds(115, 50, 100, 30);
		this.add(eNumberText);
		//电话
		teleNumber.setBounds(50, 100, 80, 30);	
		this.add(teleNumber);
		teleNumberText.setBounds(115, 100, 100, 30);
		this.add(teleNumberText);
		
		//名字
		lastName.setBounds(50, 150, 80, 30);	
		this.add(lastName);
		lastNameText.setBounds(115, 150, 100, 30);
		this.add(lastNameText);		
		firstName.setBounds(50, 175, 80, 30);	
		this.add(firstName);
		firstNameText.setBounds(115, 175, 100, 30);
		this.add(firstNameText);		
		initialName.setBounds(50, 200, 80, 30);	
		this.add(initialName);
		initialNameText.setBounds(115, 200, 100, 30);
		this.add(initialNameText);
		//部门号
		deNumber.setBounds(50, 250, 80, 30);	
		this.add(deNumber);
		deNumberText.setBounds(115, 250, 100, 30);
		this.add(deNumberText);
		//工作类型
		jobTitle.setBounds(50, 300, 80, 30);	
		this.add(jobTitle);
		jobTitleText.setBounds(115, 300, 100, 30);
		this.add(jobTitleText);
		//日期
		date.setBounds(50, 350, 80, 30);	
		this.add(date);
		dateText.setBounds(115, 350, 100, 30);
		this.add(dateText);
		
		//按钮
		addBtn.setBounds(30, 400, 60, 30);
		addBtn.addActionListener(this);
		this.add(addBtn);
		clearBtn.setBounds(110, 400, 60, 30);
		clearBtn.addActionListener(this);
		this.add(clearBtn);
		cancelBtn.setBounds(190, 400, 60, 30);
		cancelBtn.addActionListener(this);
		this.add(cancelBtn);
		
		this.setResizable(false);//窗口不可变
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addBtn) {
			addInfo();
//			new InfoAdder().addInfo();
			JOptionPane.showMessageDialog(null,"添加成功！");
			
		}
		else if(e.getSource()==clearBtn) {
			eNumberText.setText(null);
			teleNumberText.setText(null);
			lastNameText.setText(null);
			firstNameText.setText(null);
			initialNameText.setText(null);
			deNumberText.setText(null);
			jobTitleText.setText(null);
			dateText.setText(null);
		}
		else if(e.getSource()==cancelBtn) {
			this.setVisible(false);
		}
		
	}

//添加信息方法
public void addInfo() {		
		File file = new File("d:/misdata.bin");			
		//创建表存储对象
			
//		list.add(new EmployeeInfo(111, "02-98781999", "Williams", "Nick", "T", 35, "Computer Officer", "14-10-2000"));
//		list.add(new EmployeeInfo(112, "02-99893878", "Brown", "Sarah", "B", 12, "Electrician", "09-02-1992"));		
		InfoReader.list.add(new EmployeeInfo(Integer.parseInt(eNumberText.getText()),teleNumberText.getText(),
								lastNameText.getText(),firstNameText.getText(),initialNameText.getText(),
								Integer.parseInt(deNumberText.getText()),jobTitleText.getText(),dateText.getText()));
		FunctionMenu.infoWindow.setText("");
		for(EmployeeInfo i:InfoReader.list)
			FunctionMenu.infoWindow.append(String.valueOf(i.toString2())+"\n");
	}
}



//重写writeStreamHeader()
class MyObjectOutputStream extends ObjectOutputStream{

	public MyObjectOutputStream() throws IOException{
		super();
	}
	
	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	public void writeStreamHeader() throws IOException{
      return;
	}
}

