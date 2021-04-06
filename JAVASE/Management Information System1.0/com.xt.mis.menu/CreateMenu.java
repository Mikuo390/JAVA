/**
 * 
 */
package com.xt.mis.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.xt.mis.function.Function;

/**
 * @author 15159
 *
 */
public class CreateMenu extends JFrame implements ActionListener{

	JLabel Info = new JLabel("是否创建文件?");
	JButton	yesBtn = new JButton("确认");
	JButton cancelBtn = new JButton("取消");
	
	public CreateMenu() {
		this.setTitle("文件创建");
		this.setLayout(null);
		
		//组件
		Info.setBounds(100,30, 150, 50);
		this.add(Info);	
		yesBtn.addActionListener(this);
		yesBtn.setBounds(30, 100, 80, 20);
		this.add(yesBtn);
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
		if(e.getSource()==yesBtn) {
			try {
				Function.FILE.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}		
		else if(e.getSource()==cancelBtn) {
			JOptionPane.showMessageDialog(null,"Required file – records, does not exist.");
			this.setVisible(false);	
			System.exit(0);
		}
			
		
	}

	
	
}
