package com.yjh.snake;

import javax.swing.JFrame;

//游戏的主启动类
public class StartGame {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("贪吃蛇");
		jFrame.setBounds(10, 10, 900, 720);
		jFrame.setResizable(false);//窗口大小不可变
		
		//正常游戏界面都在面板上
		jFrame.add(new GamePanel());
		
		jFrame.setVisible(true);//可见性
	}
}
