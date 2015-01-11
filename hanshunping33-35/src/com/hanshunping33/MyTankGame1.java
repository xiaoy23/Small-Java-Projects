package com.hanshunping33;
import javax.swing.*;
import java.awt.*;
public class MyTankGame1 extends JFrame {
       
	MyPanel2 mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame1 mtg = new MyTankGame1();
	}
//构造函数
	public MyTankGame1(){
		mp = new MyPanel2();
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyPanel2 extends JPanel{
	//定义一个我的tank
	Hero hero=null;
	//构造函数
	public MyPanel2(){
		hero = new Hero(10,10);
	}
	//重写paint()方法
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//画出我的Tank（届时再封装成一个函数）
		//1.画出左边的矩形
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}
	
	//封装的思想，重新建一个画出tank的函数
	public void drawTank(int x ,int y,Graphics g,int direction,int type){
		switch(type){
		case 0:
			g.setColor(Color.cyan);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		case 1:
			g.setColor(Color.yellow);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		case 2:
		}
		//判断方向
		switch(direction)
		{
		//向上
		case 0 :
			g.setColor(Color.cyan);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		case 1 :
			g.setColor(Color.cyan);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		
		}
	}
}

//定义一个tank类
class Tank
{
	//Tank的横、纵坐标
	int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	int y;
	public Tank(int x,int y){
		this.x =x;
		this.y = y;
	}
}

class Hero extends Tank
{

	public Hero(int x, int y) {
		super(x, y);
	
		// TODO Auto-generated constructor stub
	}
	}