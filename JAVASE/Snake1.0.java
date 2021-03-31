package com.yjh.snake;

import java.net.URL;

import javax.swing.ImageIcon;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

//数据中心
public class Data {
	
	//相对路径 1.jpg
	//绝对路径 / 相当于当前项目
	//获取源文件，存放在 xxxxURL中
	public static URL headerURL = Data.class.getResource("/com/yjh/photos/header3.png");
	//将源文件存放在图片标签中
	public static ImageIcon header = new ImageIcon(headerURL);
	
	public static URL upURL = Data.class.getResource("/com/yjh/photos/up.png");
	public static URL downURL = Data.class.getResource("/com/yjh/photos/down.png");
	public static URL leftURL = Data.class.getResource("/com/yjh/photos/left.png");
	public static URL rightURL = Data.class.getResource("/com/yjh/photos/right.png");
	public static ImageIcon up = new ImageIcon(upURL);
	public static ImageIcon down = new ImageIcon(downURL);
	public static ImageIcon left = new ImageIcon(leftURL);
	public static ImageIcon right = new ImageIcon(rightURL);
	
	public static URL bodyURL = Data.class.getResource("/com/yjh/photos/body.png");
	public static ImageIcon body = new ImageIcon(bodyURL);
	
	public static URL foodURL = Data.class.getResource("/com/yjh/photos/food.png");
	public static ImageIcon food = new ImageIcon(foodURL);
	
}
