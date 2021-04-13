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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.xt.mis.EmployeeInfo;
import com.xt.mis.function.*;;

/**
 * @author 15159
 *
 */
public class DeleteMenu extends JFrame implements ActionListener{

	JLabel jl = new JLabel("删除员工信息");
	JLabel number = new JLabel("员工工号");
	JTextField numberText = new JTextField();
	JButton delBtn = new JButton("删除");
	JButton resetBtn = new JButton("重置");
	JButton exitBtn = new JButton("退出");
	
	public DeleteMenu() {
		this.setLayout(null);
		setTitle("删除员工信息");
		setBounds(1000, 500, 400, 300);
		
		jl.setBounds(140,50, 150, 30);
		this.add(jl);
		number.setBounds(110,100, 150, 30);
		this.add(number);
		numberText.setBounds(170,100, 100, 30);
		this.add(numberText);
		
		delBtn.setBounds(40, 180, 80, 30);
		delBtn.addActionListener(this);
		this.add(delBtn);
		resetBtn.setBounds(150, 180, 80, 30);
		resetBtn.addActionListener(this);
		this.add(resetBtn);
		exitBtn.setBounds(260, 180, 80, 30);
		exitBtn.addActionListener(this);
		this.add(exitBtn);
				
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String ID = numberText.getText();
		boolean isFind = false;
		if(e.getSource() == delBtn) {
			
			if(InfoReader.list.size()>0) {//集合内容存在
				for(int i=0;i<InfoReader.list.size();i++) {
					EmployeeInfo em = InfoReader.list.get(i);					
					if(ID.equals(String.valueOf(em.getEmployeePayrollNumber()))) {
						InfoReader.list.remove(i);//移除
						JOptionPane.showMessageDialog(null, "删除成功");
						isFind=true;
						numberText.setText(null);
						break;
					}	
				}
				if(isFind==false) {
					JOptionPane.showMessageDialog(null, "没有找到该员工！");		
				}
				FunctionMenu.infoWindow.setText("");
				for(EmployeeInfo j:InfoReader.list)
					FunctionMenu.infoWindow.append(String.valueOf(j.toString2())+"\n");			
			}
			
		}
		else if(e.getSource() == resetBtn) {
			numberText.setText(null);
		}
		else if(e.getSource() == exitBtn) {
			this.setVisible(false);
		}
		
	}
	
}
