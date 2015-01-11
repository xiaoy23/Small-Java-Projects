/*
 * TankGame1.0版
 */
package com.hanshunping34;
import javax.swing.*;
import java.awt.*;
public class MyTankGame1 extends JFrame {

	MyPanel2 mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame1 mt = new MyTankGame1();
	}
	public MyTankGame1()
	{
		mp  = new MyPanel2();
		this.add(mp);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//Define MyPanel
class MyPanel2 extends JPanel
{
	//Define a tank of mine
	Hero hero = null;
	
	//constructor 
	public MyPanel2()
	{
		hero= new Hero(100 , 100);
	}
	
	//repaint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(),hero.getY(),g,0,0);
		
	}
	//create a function to draw
	public void drawTank(int x, int y, Graphics g,int direction,int type)
	{
		//Determine the type of the tanks
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		//Determine the direction
		switch(direction)
		{
		//going up
		case 0:
			//Draw Mytank(到时再封装成一个函数)
			//1.Draw the left Rectangle
			g.fill3DRect(x, y, 5, 30,false);
			//2.Draw the right Rectangle
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.Draw the middle Rectangle
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.Draw the middle circle
			g.fillOval(x+5, y+10, 9, 9);
			//5.Draw the cannon line
			g.drawLine(x+10, y+15, x+10,  y);
			break;
		}
	}
}


class Tank
{
	//The horizontal axis of the tank
	int x = 0;
	int y= 0;
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

	public Tank(int x , int y)
	{
		this.x = x;
		this.y = y;
	}
}

//Define MyTank
class Hero extends Tank
{

	public Hero(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
}