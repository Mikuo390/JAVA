/**
 * 
 */
package com.xt.mis.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
import com.xt.mis.EmployeeInfo;
import com.xt.mis.function.InfoReader;

/**
 * @author 15159
 *
 */
public class SearchInfoMenu extends JFrame implements ActionListener {

	JLabel jl = new JLabel("搜寻员工信息");
	JLabel tip = new JLabel("请选择搜索类型");
	
	JComboBox jb = new JComboBox();
	JTextField searchText = new JTextField();
	
	JButton searchBtn = new JButton("搜索");
	JButton cancelBtn = new JButton("取消");
	
	public SearchInfoMenu() {
		this.setTitle("搜素信息");
		this.setBounds(1000, 500, 300, 400);
		this.setLayout(null);
		
		this.add(jl);
		jl.setBounds(100, 50, 150, 30);
		this.add(tip);
		tip.setBounds(90, 100, 150, 30);
		
		//选择框
		this.add(jb);
		jb.setBounds(70, 150, 150, 30);
		jb.addItem("——<请选择>——");
		jb.addItem("员工编号");
		jb.addItem("电话号码");
		jb.addItem("姓名");
		jb.addItem("部门号");
		jb.addItem("工作类型");
		this.add(searchText);
		searchText.setBounds(70, 200, 150, 30);
		
		//按钮
		this.add(searchBtn);
		searchBtn.setBounds(50, 270, 80, 30);
		searchBtn.addActionListener(this);
		this.add(cancelBtn);
		cancelBtn.setBounds(160, 270, 80, 30);
		cancelBtn.addActionListener(this);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==searchBtn) {
			boolean isFind = false;
			
			if(jb.getSelectedItem()=="员工编号") {
				if(InfoReader.list.size()>0) {//集合内容存在
					for(int i=0;i<InfoReader.list.size();i++) {
						EmployeeInfo em = InfoReader.list.get(i);					
						if(searchText.getText().equals(String.valueOf(em.getEmployeePayrollNumber()))) {
							isFind=true;
							FunctionMenu.infoWindow.setText("");
							FunctionMenu.infoWindow.append(String.valueOf(em.toString2())+"\n");
						}
					}
				}
			}
			else if(jb.getSelectedItem()=="电话号码") {
				if(InfoReader.list.size()>0) {//集合内容存在
					for(int i=0;i<InfoReader.list.size();i++) {
						EmployeeInfo em = InfoReader.list.get(i);					
						if(searchText.getText().equals(String.valueOf(em.getTeleNumber()))) {
							isFind=true;
							FunctionMenu.infoWindow.setText("");
							FunctionMenu.infoWindow.append(String.valueOf(em.toString2())+"\n");
						}
					}
				}
			}
			else if(jb.getSelectedItem()=="姓名") {
				if(InfoReader.list.size()>0) {//集合内容存在
					for(int i=0;i<InfoReader.list.size();i++) {
						EmployeeInfo em = InfoReader.list.get(i);					
						if(searchText.getText().equalsIgnoreCase(String.valueOf(em.getLastName()))  
							|| searchText.getText().equalsIgnoreCase(String.valueOf(em.getFirstName())) 
							|| searchText.getText().equalsIgnoreCase(String.valueOf(em.getInitialName()))) {
							isFind=true;
							FunctionMenu.infoWindow.setText("");
							FunctionMenu.infoWindow.append(String.valueOf(em.toString2())+"\n");
						}
					}
				}
			}
			else if(jb.getSelectedItem()=="部门号") {
				if(InfoReader.list.size()>0) {//集合内容存在
					for(int i=0;i<InfoReader.list.size();i++) {
						EmployeeInfo em = InfoReader.list.get(i);					
						if(searchText.getText().equals(String.valueOf(em.getDepartmentNumber()))) {
							isFind=true;
							FunctionMenu.infoWindow.setText("");
							FunctionMenu.infoWindow.append(String.valueOf(em.toString2())+"\n");
						}
					}
				}
			}
			else if(jb.getSelectedItem()=="工作类型") {
				if(InfoReader.list.size()>0) {//集合内容存在
					for(int i=0;i<InfoReader.list.size();i++) {
						EmployeeInfo em = InfoReader.list.get(i);					
						if(searchText.getText().equalsIgnoreCase(String.valueOf(em.getJobTitle()))) {
							isFind=true;
							FunctionMenu.infoWindow.setText("");
							FunctionMenu.infoWindow.append(String.valueOf(em.toString2())+"\n");
						}
					}
				}
			}
			if(isFind==false) {
				JOptionPane.showMessageDialog(null, "未找到该员工");
			}
			else if(isFind==true) {
				JOptionPane.showMessageDialog(null, "已找到该员工");
			}
			
		}
		else if(e.getSource()==cancelBtn) {
			this.setVisible(false);
		}
		
	}
}
