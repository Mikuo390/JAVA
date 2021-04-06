/**
 * 
 */
package com.xt.mis.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Savepoint;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.xt.mis.function.Function;
import com.xt.mis.function.InfoReader;
import com.xt.mis.function.InfoSaver;

/**
 * @author 15159
 *
 */
public class FunctionMenu extends JFrame implements ActionListener{

	//欢迎语
//	JPanel panel1 = new JPanel();
	JLabel tip1 = new JLabel("欢迎使用信息管理系统");
	JLabel tip2 = new JLabel("单击按钮选择功能");
	JLabel tip3 = new JLabel("鼠标悬浮可查看详细介绍");
	
//	JPanel panel2 = new JPanel();
	//右上角的用户名
	JButton userNameBtn = new JButton("用户名:"+LoginMenu.UN);
	//说明按钮
	JButton InstructionBtn = new JButton("说明");
	JButton exitBtn = new JButton("退出");
	
//	JPanel panel3 = new JPanel();
	//功能按钮
	JButton btn1 = new JButton("显示信息");
	JButton btn2 = new JButton("显示信息(排序)");
	JButton btn3 = new JButton("显示信息(名字和电话)");
	JButton btn4 = new JButton("显示信息(排序的名字和电话)");
	JButton btn5 = new JButton("查找");
	JButton btn6 = new JButton("添加");
	JButton btn7 = new JButton("删除");
	JButton btn8 = new JButton("保存");
	JButton btn9 = new JButton("待更新");
	
	//信息显示窗口
	public static JTextArea infoWindow = new JTextArea();
	//滚动条
	JScrollPane jinfoWindow = new JScrollPane(infoWindow);
	

	public FunctionMenu() {
		InfoReader.readInfo();//创建菜单直接读取文件

		this.setTitle("讯通科技——员工信息管理系统功能界面");
		//设置布局
		this.setLayout(null);
		
		//欢迎语布局
		tip1.setBounds(36, 10, 500, 20);
//		tip1.setBorder(BorderFactory.createEtchedBorder());
		this.add(tip1);
		tip2.setBounds(40, 30, 500, 20);
		this.add(tip2);
		tip3.setBounds(35, 50, 500, 20);
		this.add(tip3);
		
		//上方信息按钮
		userNameBtn.setBounds(1173, 10, 200, 20);
		userNameBtn.addActionListener(this);
		this.add(userNameBtn);
		InstructionBtn.setBounds(1400, 10, 80, 20);
		this.add(InstructionBtn);
		exitBtn.setBounds(1500, 10, 80, 20);
		exitBtn.addActionListener(this);
		this.add(exitBtn);
		
		//信息显示窗口
//		infoWindow.setBounds(200, 100, 1300, 700);
//		this.add(infoWindow);
		infoWindow.setFont(new Font("宋体", Font.BOLD,20));
		jinfoWindow.setBounds(200, 100, 1300, 700);
		this.add(jinfoWindow);

		//功能按钮
		btn1.setBounds(50, 100, 100, 50);
		btn1.setToolTipText("在屏幕上显示所有员工信息");
		btn1.addActionListener(this);
		this.add(btn1);
		
		btn2.setBounds(50, 175, 100, 50);
		btn2.setToolTipText("在屏幕上显示所有员工信息(格式化且排序)");
		btn2.addActionListener(this);
		this.add(btn2);
		
		btn3.setBounds(50, 250, 100, 50);
		btn3.setToolTipText("在屏幕上显示所有员工的名字和电话");
		btn3.addActionListener(this);
		this.add(btn3);
		
		btn4.setBounds(50, 325, 100, 50);
		btn4.setToolTipText("在屏幕上显示所有员工的名字和电话(格式化且排序)");
		btn4.addActionListener(this);
		this.add(btn4);
		
		btn5.setBounds(50, 400, 100, 50);
		btn5.setToolTipText("搜索和显示特定员工信息");
		btn5.addActionListener(this);
		this.add(btn5);
		
		btn6.setBounds(50, 475, 100, 50);
		btn6.setToolTipText("在本地文件中增加的信息");
		btn6.addActionListener(this);
		this.add(btn6);
		
		btn7.setBounds(50, 550, 100, 50);
		btn7.setToolTipText("删除在本地文件的信息");
		btn7.addActionListener(this);
		this.add(btn7);
		
		btn8.setBounds(50, 625, 100, 50);
		btn8.setToolTipText("在本地文件中保存");
		btn8.addActionListener(this);
		this.add(btn8);
		
		btn9.setBounds(50, 700, 100, 50);
		btn9.setToolTipText("待添加");
		btn9.addActionListener(this);
		this.add(btn9);
		
		this.setResizable(false);//窗口不可变
		this.setBounds(500,300,1600,900);
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==userNameBtn) {
			new userMenu();
		}
		else if(e.getSource()==InstructionBtn) {
			
		}
		else if(e.getSource()==exitBtn) {
			new ExitMenu();
		}
		else if(e.getSource()==btn1) {
			Function.printInfo();
		}
		else if(e.getSource()==btn2) {
			Function.printFormattedInfo();
		}
		else if(e.getSource()==btn3) {
			Function.printNameAndTeleInfo();
		}
		else if(e.getSource()==btn4) {
			Function.printFormattedNameAndTeleInfo();
		}
		else if(e.getSource()==btn5) {
			Function.searchInfo();
		}
		else if(e.getSource()==btn6) {
			Function.addInfo();
		}
		else if(e.getSource()==btn7) {
			Function.deleteInfo();
		}
		else if(e.getSource()==btn8) {
			InfoSaver.saveInfo();
		}
		else if(e.getSource()==btn9) {
			
		}
		
			
	}
}
