/**
 * 
 */
package com.xt.mis.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author 15159
 *
 */
public class userMenu extends JFrame implements ActionListener{

	//头像
	URL url = userMenu.class.getResource("1.gif");//头像路径记得改
	JLabel label = new JLabel();
	ImageIcon ii = new ImageIcon(url); 
	
	//用户名标签
	JLabel userName = new JLabel("用户名");
	JTextField userNameText = new JTextField(LoginMenu.UN);
	//密码标签
	JLabel password = new JLabel("密码");
	JTextField passwordText = new JTextField(LoginMenu.PS);
	
	//按钮
	JButton confirmBtn = new JButton("确定");
	JButton cancelBtn = new JButton("取消");
	
	
	
	public userMenu() {
		this.setTitle("用户界面");
		this.setBounds(1000, 500, 300, 400);
		this.setLayout(null);
		
		//头像 
		label.setIcon(ii);
		label.setBounds(45, 20, 200, 200);
		this.add(label);
		
		//用户名
		userName.setBounds(70, 235, 100, 20);
		this.add(userName);
		userNameText.setBounds(120, 235, 100, 20);
		userNameText.getText();
		this.add(userNameText);
		//密码
		password.setBounds(70, 265, 100, 20);
		this.add(password);
		passwordText.setBounds(120, 265, 100, 20);
		passwordText.getText();
		this.add(passwordText);
		
		//按钮
		confirmBtn.setBounds(30, 300, 100, 40);
		confirmBtn.addActionListener(this);
		this.add(confirmBtn);
		cancelBtn.setBounds(150, 300, 100, 40);
		cancelBtn.addActionListener(this);
		this.add(cancelBtn);
		
		this.setResizable(false);//窗口不可变
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==confirmBtn) {
			this.setVisible(false);
		}
		else if(e.getSource()==cancelBtn) {
			this.setVisible(false);
		}
		
	}
	
}
