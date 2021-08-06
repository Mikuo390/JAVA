package com.yjh.complex.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.yjh.complex.utils.AbsCalc;
import com.yjh.complex.utils.AddCalc;
import com.yjh.complex.utils.CalcFactory;
import com.yjh.complex.utils.CalcType;
import com.yjh.complex.utils.DataChecker;
import com.yjh.complex.utils.DataCleaner;
import com.yjh.complex.utils.DivCalc;
import com.yjh.complex.utils.MultCalc;
import com.yjh.complex.utils.SubCalc;


public class CalcUI extends JFrame implements ActionListener{
	
	//两个面板
	//显示面板
	JPanel displayPanel = new JPanel();
	//操作面板
	JPanel operationPanel = new JPanel();
	
	//复数显示面板
	public static JTextField realpartText1 = new JTextField();
	public static JTextField imagpartText1 = new JTextField();
	public static JTextField realpartText2 = new JTextField();
	public static JTextField imagpartText2 = new JTextField();	
	public static JTextField realpartResult = new JTextField();
	public static JTextField imagpartResult = new JTextField();
	public static JTextField symbolText = new JTextField();
	JLabel c1 = new JLabel("复数C1");
	JLabel c2 = new JLabel("复数C2");
	JLabel label0 = new JLabel("＋");
	JLabel label1 = new JLabel("＋");
	JLabel label2 = new JLabel("＋");
	JLabel label3 = new JLabel("i");
	JLabel label4 = new JLabel("i");
	JLabel label5 = new JLabel("i");
	JLabel label6 = new JLabel("=");
	JLabel result = new JLabel("计算结果");
	JLabel symbol = new JLabel("运算符");
	
	//运算符号按钮
	JButton addBtn = new JButton("＋");
	JButton subBtn = new JButton("－");
	JButton multBtn = new JButton("×");
	JButton divBtn = new JButton("÷");
	JButton absBtn = new JButton("||");
	
	//清空按钮
	JButton clearBtn = new JButton("C");
	
	//定义静态内部类
	private static class CalcUIHolder{
		private static final CalcUI INSTANCE = new CalcUI();
	}
	
	//提供一个公共的访问方式，让外界获取该对象
	public static CalcUI getInstance() {
		return CalcUIHolder.INSTANCE;
	}
	
	//私有化构造方法
	private CalcUI() {
		this.setTitle("复数计算器——先输入数字在点击运算符");//设置 
		this.setLayout(null);//设置布局
		
		//显示面板
		this.add(displayPanel);//面板1
		displayPanel.setBounds(0, 0, 400, 200);//面板大小
//		displayPanel.setBackground(Color.BLUE);
		displayPanel.setLayout(null);
		
		//复数C1面板
		displayPanel.add(c1);
		c1.setBounds(10, 10, 50, 30);
		displayPanel.add(realpartText1);//实部
		realpartText1.setBounds(70, 10, 100, 30);
		displayPanel.add(imagpartText1);//虚部
		imagpartText1.setBounds(250, 10, 100, 30);
		displayPanel.add(label1);//符号
		label1.setBounds(205, 10, 50, 30);
		label1.setFont(new Font("宋体", Font.BOLD,20));
		displayPanel.add(label3);
		label3.setBounds(350, 10, 50, 30);
		label3.setFont(new Font("宋体", Font.BOLD,20));
		
		//运算符
		displayPanel.add(symbol);
		symbol.setBounds(150, 50, 50, 30);
		displayPanel.add(symbolText);
		symbolText.setBounds(200, 50, 29, 30);
		symbolText.setFont(new Font("宋体", Font.BOLD,20));
		
		//复数C2面板
		displayPanel.add(c2);
		c2.setBounds(10, 90, 50, 30);
		displayPanel.add(realpartText2);
		realpartText2.setBounds(70, 90, 100, 30);
		displayPanel.add(imagpartText2);
		imagpartText2.setBounds(250, 90, 100, 30);
		displayPanel.add(label2);//符号
		label2.setBounds(205, 90, 50, 30);
		label2.setFont(new Font("宋体", Font.BOLD,20));
		displayPanel.add(label4);
		label4.setBounds(350, 90, 50, 30);
		label4.setFont(new Font("宋体", Font.BOLD,20));
		
		//等号
		displayPanel.add(label6);
		label6.setBounds(200, 120, 50, 30);
		label6.setFont(new Font("宋体", Font.BOLD,20));
		
		//结果面板
		displayPanel.add(result);
		result.setBounds(10, 150, 60, 30);
		displayPanel.add(realpartResult);
		realpartResult.setBounds(70, 150, 100, 30);
		displayPanel.add(imagpartResult);
		imagpartResult.setBounds(250, 150, 100, 30);
		displayPanel.add(label0);//符号
		label0.setBounds(205, 150, 50, 30);
		label0.setFont(new Font("宋体", Font.BOLD,20));
		displayPanel.add(label5);
		label5.setBounds(350, 150, 50, 30);
		label5.setFont(new Font("宋体", Font.BOLD,20));
		
		//操作面板
		this.add(operationPanel);//面板2
		operationPanel.setBounds(0, 200, 400, 400);//面板大小
//		operationPanel.setBackground(Color.red);
		operationPanel.setLayout(new GridLayout(4, 4));//设置布局方式
		operationPanel.add(addBtn);
		operationPanel.add(subBtn);
		operationPanel.add(multBtn);
		operationPanel.add(divBtn);
		operationPanel.add(absBtn);
		operationPanel.add(clearBtn);
		
		addBtn.setFont(new Font("宋体", Font.BOLD,40));
		subBtn.setFont(new Font("宋体", Font.BOLD,40));
		multBtn.setFont(new Font("宋体", Font.BOLD,40));
		divBtn.setFont(new Font("宋体", Font.BOLD,40));
		absBtn.setFont(new Font("宋体", Font.BOLD,40));
		clearBtn.setFont(new Font("宋体", Font.BOLD,40));
		
		
		absBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		addBtn.addActionListener(this);
		subBtn.addActionListener(this);
		multBtn.addActionListener(this);
		divBtn.addActionListener(this);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置可关闭窗口
		this.setResizable(false);//窗口不可变
		this.setBounds(500,300,415,540);
		this.setVisible(true);//设置可见性		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(clearBtn)) {
			DataCleaner.clearData();
		}
		else if(e.getSource().equals(addBtn)) {
			symbolText.setText("＋");
			if(DataChecker.checkData())
				CalcFactory.getInstance().getCalcRole(CalcType.ADD_CALC);
		}
		else if(e.getSource().equals(subBtn)) {
			symbolText.setText("－");
			if(DataChecker.checkData())
				CalcFactory.getInstance().getCalcRole(CalcType.SUB_CALC);
		}
		else if(e.getSource().equals(multBtn)) {
			symbolText.setText("×");
			if(DataChecker.checkData())
				CalcFactory.getInstance().getCalcRole(CalcType.MULT_CALC);
		}
		else if(e.getSource().equals(divBtn)) {
			symbolText.setText("÷");
			if(DataChecker.checkData())
				CalcFactory.getInstance().getCalcRole(CalcType.DIV_CALC);
		}
		else if(e.getSource().equals(absBtn)) {
			symbolText.setText("||");
			CalcFactory.getInstance().getCalcRole(CalcType.ABS_CALC);
		}
		
	}
	
	
}
