/*
 * TankGame3.0版
 * 1.画出坦克
 * 2.我的坦克可以上下左右移动
 */
package com.hanshunping39TankGame3;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
public class MyTankGame3 extends JFrame {

	MyPanel2 mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame3 mt = new MyTankGame3();
	}
	public MyTankGame3()
	{
		mp  = new MyPanel2();
		//Start mp thread.
		Thread t = new Thread(mp);
		t.start();
		this.add(mp);
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(mp);
	}
}

//Define MyPanel
class MyPanel2 extends JPanel implements KeyListener,Runnable
{
	//Define a tank of mine
	Hero hero = null;
	//Define an enemy's tank
	Vector <EnemyTank> ets = new Vector<EnemyTank>();
	int enSize = 3;

	
	//constructor 
	public MyPanel2()
	{
		hero= new Hero(100 , 100);
		
		//Initialize enemy's tanks
		for (int i = 0; i<enSize+1 ; i++)
		{
			//Create an enemy's tank 
			EnemyTank et = new EnemyTank((i - 1)* 50 , 0);
			et.setColor(0);
			et.setDirect(1);
			//Add
			ets.add(et);
		}
	}
	
	//repaint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 600, 600);
		
		//Draw my own tank
		this.drawTank(hero.getX(),hero.getY(),g,this.hero.getDirect(),0);
		//Draw the bullets
		if(hero.s!=null)
		{
			g.draw3DRect(hero.s.x, hero.s.y, 2, 2, false);
		}
		//Draw the enemy's tanks 
		for(int i = 0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(), 1);
		}
	}
	
	//create a function to draw
	//Expand the function
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
			//Draw Mytank (到时再封装成一个函数)
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
		//moving down	
		case 1:
			//1.Draw the left Rectangle
			g.fill3DRect(x, y, 5, 30,false);
			//2.Draw the right Rectangle
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.Draw the middle Rectangle
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.Draw the middle circle
			g.fillOval(x+5, y+10, 9, 9);
			//5.Draw the cannon line
			g.drawLine(x+10, y+15, x+10,  y+30);
			break;
		//moving to the left
		case 2:
			//Draw the upper Rectangle
			g.fill3DRect(x, y, 30, 5, false);
			//Draw the lower Rectangle
			g.fill3DRect(x,y+15,30,5,false);
			//Draw the middle Rectangle
			g.fill3DRect(x+5,y+5,20,10,false);
			//Draw the middle circle
			g.fillOval(x+10, y+5, 10, 10);
			//Draw the line
			g.drawLine(x + 15, y + 10, x , y + 10);
			break;
		//moving to the right 	
		case 3:
			//Draw the upper Rectangle
			g.fill3DRect(x, y, 30, 5, false);
			//Draw the lower Rectangle
			g.fill3DRect(x,y+15,30,5,false);
			//Draw the middle Rectangle
			g.fill3DRect(x+5,y+5,20,10,false);
			//Draw the middle circle
			g.fillOval(x+10, y+5, 10, 10);
			//Draw the line
			g.drawLine(x + 15, y + 10, x + 30, y + 10);
			break;
		}
	}

	//键按下的处理 a 左 d右 w上 s下
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			//Set the tanks' directions
			this.hero.setDirect(0); // up
			this.hero.movingup();
		}
		else if (e.getKeyCode() == KeyEvent.VK_S)
		{
			this.hero.setDirect(1);
			this.hero.movingdown();
		}
		else if (e.getKeyCode() == KeyEvent.VK_A)
		{
			this.hero.setDirect(2);
			this.hero.movingleft();
		}
		else if (e.getKeyCode() == KeyEvent.VK_D)
		{
			this.hero.setDirect(3);
			this.hero.movingright();
		}
		
		//can shot while running ,thus using another "if"
		if (e.getKeyCode()==KeyEvent.VK_J)
		{
			//If the player pressed "J"
			//Fire
			this.hero.shotEnemy();
		}	
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Every 100ms, repaint the panel
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//Repaint
			this.repaint();
		}
	}
}


