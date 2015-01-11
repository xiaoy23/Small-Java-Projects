/*
 * TankGame4.0版

 * 1.画出坦克
 * 2.我的坦克可以上下左右移动
 * 3.我的坦克子弹可以连发，最多连发5颗
 * 4.当我方坦克击中敌人坦克的时候，敌人的坦克就爆炸
 * 5.当敌人坦克击中我方坦克的时候，我方坦克就爆炸
 */
package com.hanshunping41;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.io.*;
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
	
	//Define the bomb vector
	Vector<Bomb> bombs = new Vector<Bomb>();
	
	
	int enSize = 3;
	//三张图片组合成一个炸弹
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	
	//constructor 
	public MyPanel2()
	{
		hero= new Hero(100 , 100);
		
		//Initialize enemy's tanks
		for (int i = 0; i<enSize ; i++)
		{
			//Create an enemy's tank 
			EnemyTank et = new EnemyTank((i+1) * 50 , 0);
			et.setColor(0);
			et.setDirect(1);
			//Start the enemy's tank
			Thread t = new Thread(et);
			t.start();
			Shot s = new Shot(et.x+10,et.y+30,2);
			//attach to enemy's tank
			et.ss.add(s);
			Thread t2 = new Thread(s);
			t2.start();
			
			//Add
			ets.add(et);
		}
//		try{
//			image1 = ImageIO.read(new File("explosion1.gif"));
//			image2 = ImageIO.read(new File("explosion2.gif"));
//			image3 = ImageIO.read(new File("explosion3.gif"));
//			
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		//Initialize the images
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/explosion1.gif"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/explosion2.gif"));
		image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/explosion3.gif"));
	}
	
	//repaint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 600, 600);
		
		//Draw my own tank
		if(hero.isLive ==true)
		{
			this.drawTank(hero.getX(),hero.getY(),g,this.hero.getDirect(),0);
		}
		//Get every single bullet and draw it out
		for(int i = 0;i<hero.ss.size();i++)
		{
				Shot myShot = hero.ss.get(i);
				//Draw one bullet
				if(myShot!=null&&myShot.isLive() == true)
				{
					g.draw3DRect(myShot.x, myShot.y, 2, 2, false);
				}
				if(myShot.isLive() == false)
				{
					//从Vector ss中删除该子弹
					hero.ss.remove(myShot);
				}
		}
		//Draw the bombs
		for(int i = 0; i< bombs.size();i++)
		{
			//get the bombs
			Bomb b = bombs.get(i);
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30, 30,this);
			}
			else if (b.life>3)
			{
				g.drawImage(image2, b.x, b.y, 30, 30,this);
			}
			else
			{
				g.drawImage(image3, b.x, b.y, 30, 30,this);
			}
			//Subtract health
			b.lifedown();
			//if life equals zero, we can delete the bomb from the vector
			if(b.life == 0)
			{
				bombs.remove(b);
			}
		
		}
		//Draw the enemy's tanks 
		for(int i = 0;i<ets.size();i++)
		{
			EnemyTank et = ets.get(i);
			if(et.isLive)
			{
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 1);
				//Draw enemy's tank
				for(int j = 0;j<et.ss.size();j++)
				{
					//get the bullet 
					Shot enemyShot = et.ss.get(j);
					if(enemyShot.isLive)
					{
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
					}else
					{
						//If enemy's tank is dead,remove from vector
						et.ss.remove(enemyShot);
					}
				}
			}
		}
	}
	
	public void hitEnemyTank()
	{
		//Decide whether the tank is hit
		for(int i = 0;i<hero.ss.size();i++)
		{
			//get the bullets
			Shot myShot = hero.ss.get(i);
			//Decide whether the bullet is working
			if(myShot.isLive)
			{
				//get every enemy's tank and match with the bullets
				for(int j = 0;j<ets.size();j++)
				{
					//get the tank
					EnemyTank et = ets.get(j);
					if(et.isLive)
					{
						this.hitTank(myShot, et);
					}
				}
			}
		}
		//Determine whether add new bullets to tanks
		for(int i = 0; i<ets.size();i++)
		{
			EnemyTank et = ets.get(i);
			if(et.isLive)
			{
				if(et.ss.size()<5)
				{
					Shot s = null;
				
				//There 's no bullet
				//add bullet
				switch(et.direct)
				{
				case 0:
					s= new Shot(et.x+10,et.y,0);
					et.ss.add(s);
					break;
				case 3:
					s = new Shot(et.x +30,et.y+10,3);
					et.ss.add(s);
					break;
				case 1:
					s = new Shot(et.x + 10,et.y +30,1);
					et.ss.add(s);
					break;
				case 2:
					s = new Shot(et.x , et.y+10,2);
					et.ss.add(s);
					break;
				}
				Thread t = new Thread(s);
				t.start();
				}
			}
		}
	}
	
	//Whether enemies'  bullet hit the me
	public void hitMe()
	{
		for(int i = 0;i<this.ets.size();i++)
		{
			//get the tanks
			EnemyTank et = ets.get(i);
			for(int j = 0;j < et.ss.size();j++)
			{
				//get the bullets
				Shot enemyShot = et.ss.get(j);
				
				this.hitTank(enemyShot, hero);
			}
		}
	}
	
	//Create a function to tell whether the bullet hit the enemies
	public void hitTank(Shot s, Tank et)
	{
		//Decide the direction of the tank
		switch(et.direct){
		//If enemy's tank going up/down
		case 0:
		case 1:
			if(s.x>=et.x&&s.x<=et.x+20&&s.y >=et.y &&s.y<=et.y+30)
			{
				//been hit
				//the bullet died
				s.isLive=false;
				//the enemy tank died
				et.isLive = false;
				//create a bomb, put into the vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);
				
			}
		case 2:
		case 3:
			if(s.x>=et.x &&s.x<=et.x+30&&s.y>=et.y&&s.y<=et.y+20)
			{
				//been hit
				//the bullet died
				s.isLive=false;
				//the enemy tank died
				et.isLive = false;
				//create a bomb, put into the vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);
			}
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
			if(this.hero.ss.size()<=4)
			{
			this.hero.shotEnemy();
			}
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
			
			this.hitEnemyTank();
			//Another function to determine whether myTank is hit by Enemy
			this.hitMe();
			//Repaint
			this.repaint();
		}
	}
}


