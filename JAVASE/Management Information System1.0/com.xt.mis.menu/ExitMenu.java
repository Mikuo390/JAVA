/**
 * 
 */
package com.xt.mis.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author 15159
 *
 */
public class ExitMenu extends JFrame implements ActionListener {

	JLabel Info = new JLabel("确认退出?");
	JButton	exitBtn = new JButton("确认");
	JButton cancelBtn = new JButton("取消");
	
	public ExitMenu() {
		this.setTitle("退出确认");
		this.setLayout(null);
		
		//组件
		Info.setBounds(100,30, 150, 50);
		this.add(Info);	
		exitBtn.addActionListener(this);
		exitBtn.setBounds(30, 100, 80, 20);
		this.add(exitBtn);
		cancelBtn.addActionListener(this);
		cancelBtn.setBounds(170, 100, 80, 20);
		this.add(cancelBtn);
		
		//外部框架设置
		this.setResizable(false);//窗口不可变
		this.setBounds(1150, 550, 300, 200);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitBtn)
			System.exit(0);
		else if(e.getSource()==cancelBtn)
			this.setVisible(false);
	}
}
