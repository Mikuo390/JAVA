package com.yjh.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


//游戏面板
public class GamePanel extends JPanel implements KeyListener,ActionListener{
	
	//定义蛇的数据结构
	int length;//蛇的长度
	int[] snakeX = new int[600];//蛇的x坐标 25*25
	int[] snakeY = new int[500];//蛇的Y坐标 25*25
	String dir;
	
	//食物的坐标
	int foodx;
	int foody;
	Random random= new Random();
	
	//积分展示
	int score;
	
	//游戏当前的状态：开始 停止
	boolean isStart = false;//默认是不开始
	
	//游戏是否失败
	boolean isFail = false;
	
	//定时器 以ms为单位
	Timer timer = new Timer(100,this);//100毫秒执行一次
	
	//构造器
	public GamePanel() {
		super();
		init();
		//获得焦点和键盘事件
		this.setFocusable(true);//获得焦点事件
		this.addKeyListener(this);//获取当前类内的键盘监听
		timer.start();//游戏一开始定时器就启动
	}


	//初始化方法
	public void init() {
		length = 3;
		snakeX[0] = 100;snakeY[0] = 100;//脑袋的坐标
		snakeX[1] = 75;snakeY[1] = 100;//第一个身体的坐标
		snakeX[2] = 50;snakeY[2] = 100;//第二个身体坐标
		dir = "R";//初始方法向右
		
		//一格为25，把食物随机分布在界面上
		foodx = 25 + 25*random.nextInt(34);
		foody = 75 + 25*random.nextInt(24);
		
		score=0;
	}
	
	
	//绘制面板,游戏所有东西都是用这个
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);//清屏作用
		
		//绘制静态的面板		
		this.setBackground(Color.WHITE);
		Data.header.paintIcon(this, g, 25, 11);//头部宣传栏
		g.fillRect(25, 75, 850, 600);//默认的游戏界面
		
		//小标语
		g.setColor(Color.BLACK);
		g.setFont(new Font("微软雅黑",Font.BOLD,25));
		g.drawString("一个非常简单的贪吃蛇游戏", 50, 35);
		
		//画积分
		g.setColor(Color.BLACK);
		g.setFont(new Font("微软雅黑",Font.BOLD,18));
		g.drawString("长度:"+length, 750, 35);
		g.drawString("分数:"+score, 750, 60);
		
		//画食物
		Data.food.paintIcon(this, g, foodx, foody);
		
		//把小蛇画上去
		if(dir.equals("R")) {
			Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(dir.equals("L")) {
			Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(dir.equals("U")) {
			Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(dir.equals("D")) {
			Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
		}
		
		//小蛇移动的坐标
		for(int i=1;i<length;i++) {
			Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);//第一个身体
		}
//		Data.body.paintIcon(this, g, snakeX[1], snakeY[1]);//第一个身体
//		Data.body.paintIcon(this, g, snakeX[2], snakeY[2]);//第二个身体
		
		//游戏状态
		if(isStart==false) {
			//设置颜色
			g.setColor(Color.white);
			//设置字体
			g.setFont(new Font("微软雅黑",Font.BOLD,40));
			g.drawString("按下空格开始游戏",300,300);
		}
		
		if(isFail) {
			//设置颜色
			g.setColor(Color.RED);
			//设置字体
			g.setFont(new Font("微软雅黑",Font.BOLD,40));
			g.drawString("失败！按下空格重新开始",300,300);
		}
		
	}


	//键盘监听事件
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();//获取键盘按键
		if(keyCode == KeyEvent.VK_SPACE) {//空格
//			isStart = !isStart;//取反
//			repaint();
			if(isFail) {
				//重新开始
				isFail=false;
				init();
			}else {
				isStart = !isStart;//取反
			}
			repaint();
		}
		//小蛇移动
		if(keyCode==KeyEvent.VK_UP) {
			dir = "U";
		}else if(keyCode==KeyEvent.VK_DOWN) {
			dir = "D";
		}else if(keyCode==KeyEvent.VK_LEFT) {
			dir = "L";
		}else if(keyCode==KeyEvent.VK_RIGHT) {
			dir = "R";
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

	
	//事件监听--需要通过固定事件来刷新：1s=10次
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isStart && isFail==false) {//开始状态且不是失败状态，小蛇才动
			
			//吃食物
			if(snakeX[0]==foodx && snakeY[0]==foody) {
				//长度+1
				length++;
				//分数+1
				score+=10;
				//再次随机食物
				foodx = 25 + 25*random.nextInt(34);
				foody = 75 + 25*random.nextInt(24);
			}
			
			//移动
			for(int i=length-1;i>0;i--) {//后一节移到前一节的位置
				snakeX[i] = snakeX[i-1];
				snakeY[i] = snakeY[i-1];
			}
			
			//走向//头移动
			if(dir.equals("R")) {
				snakeX[0] = snakeX[0]+25;
				//边界判断
				if(snakeX[0]>850) {snakeX[0]=25;}
			}else if(dir.equals("L")) {
				snakeX[0] = snakeX[0]-25;
				//边界判断
				if(snakeX[0]<25) {snakeX[0]=850;}
			}else if(dir.equals("U")) {
				snakeY[0] = snakeY[0]-25;
				//边界判断
				if(snakeY[0]<75) {snakeY[0]=650;}
			}else if(dir.equals("D")) {
				snakeY[0] = snakeY[0]+25;
				//边界判断
				if(snakeY[0]>650) {snakeY[0]=75;}
			}
			
			//失败判断撞到自己就算失败
			for(int i=1;i<length;i++) {
				if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]) {
					isFail = true;
				}
			}
					
			repaint();//重画页面
		}
		timer.start();//定时器开启
	}
	
}
