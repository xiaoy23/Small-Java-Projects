/*
 * TankGame5.0版

 * 1.画出坦克
 * 2.我的坦克可以上下左右移动
 * 3.我的坦克子弹可以连发，最多连发5颗
 * 4.当我方坦克击中敌人坦克的时候，敌人的坦克就爆炸
 * 5.当敌人坦克击中我方坦克的时候，我方坦克就爆炸
 * 6.防止敌人坦克重叠运动
 * 	6.1决定把判断是否碰撞的函数写到EnemyTank类里去
 * 7.可以分关
 * 	7.1做一个开始的Panel，他是空的
 * 8.可以再玩游戏的时候暂停和继续
 * 	8.1当用户点击暂停时，子弹和坦克的速度设为零，并让坦克的方向不要变化
 * 9.可以记录玩家的成绩
 * 	9.1用文件流
 * 	9.2单写一个记录类，完成对玩家的记录
 * 	9.3先完成保存共击毁多少辆敌人坦克的功能
 * 	9.4存盘退出游戏可以记录当时的敌人坦克坐标，并且可以恢复
 * 10.java如何操作声音文件
 */
package com.hanshunping47;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.io.*;
public class MyTankGame3 extends JFrame implements ActionListener{

	
	MyPanel2 mp = null;
	//Define a startPanel
	MyStartPanel myStartPanel = null;
	//Build a menu
	JMenuBar jmb = null;
	//start the game;
	JMenu jm1 = null;
	JMenuItem jmi1 = null;
	//exit the system
	JMenuItem jmi2 = null;
	//save and exit
	JMenuItem jmi3 = null;
	//continue to play
	JMenuItem jmi4 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame3 mt = new MyTankGame3();
	}
	public MyTankGame3()
	{
		//mp  = new MyPanel2();
		//Start mp thread.
		//Thread t = new Thread(mp);
		//t.start();
		//this.add(mp);
		
		
		//this.addKeyListener(mp);
		
		//create meanu
		jmb = new JMenuBar();
		jm1 = new JMenu("Game(G)");
		jmi1 = new JMenuItem("Start New Game(N)");
		//set a quick start 
		jmi2 = new JMenuItem("Exit(E)");
		jmi3 = new JMenuItem("Save and Exit(S)");
		jmi4 = new JMenuItem("Continue(C)");
		jm1.setMnemonic('G');
		jmi2.setMnemonic('E');
		//react to jmi1
		jmi1.addActionListener(this);
		jmi1.setActionCommand("New Game");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("Exit");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("Save and Exit");
		jmi4.addActionListener(this);
		jmi4.setActionCommand("Continue");
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		
		jmb.add(jm1);
		
		myStartPanel = new MyStartPanel();
		Thread t = new Thread(myStartPanel);
		t.start();
		
		this.setJMenuBar(jmb);
		this.add(myStartPanel);
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//Perform different actions according to users order
		if(arg0.getActionCommand().equals("New Game"))
		{
			//create battle filed panel
			mp  = new MyPanel2("newGame");
			//Start mp thread.
			Thread t = new Thread(mp);
			t.start();
			//Delete old panel first
			this.remove(myStartPanel);
			this.add(mp);
			
			this.addKeyListener(mp);
			//repaint JFrame
			this.setVisible(true);
		}else if(arg0.getActionCommand().equals("Exit"))
		{
			//user clicked "Exit"
			//save the scores
			Recorder.keepRecording();
			System.exit(0);
		}
		//process save and exit
		else if (arg0.getActionCommand().equals("Save and Exit"))
		{
			Recorder rd = new Recorder();
			rd.setEts(mp.ets);
			//1.save the total number that has been destroyed
			rd.keepRecordEnemyTank();
			//exit
			System.exit(0);
			
		}else if(arg0.getActionCommand().equals("Continue"))
		{
			//create battle filed panel
			mp  = new MyPanel2("con");
			
			
			//Start mp thread.
			Thread t = new Thread(mp);
			t.start();
			//Delete old panel first
			this.remove(myStartPanel);
			this.add(mp);
			
			this.addKeyListener(mp);
			//repaint JFrame
			this.setVisible(true);
		}
	}
}

//Define MyPanel
class MyPanel2 extends JPanel implements KeyListener,Runnable
{
	//Define a tank of mine
	Hero hero = null;
	
	//Define an enemy's tank
	Vector <EnemyTank> ets = new Vector<EnemyTank>();
	Vector<Node> nodes = new Vector<Node>();
	//Define the bomb vector
	Vector<Bomb> bombs = new Vector<Bomb>();
	
	
	int enSize = 10;
	//三张图片组合成一个炸弹
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	
	//constructor 
	public MyPanel2(String flag)
	{
		//revive the records
		Recorder.getRecording();
		
		hero= new Hero(100 , 100);
		
		if(flag.equals("newGame"))
		{	
			//Initialize enemy's tanks
			for (int i = 0; i<enSize ; i++)
			{
				//Create an enemy's tank 
				EnemyTank et = new EnemyTank((i+1) * 50 , 0);
				et.setColor(0);
				et.setDirect(1);
				//将MyPanel的敌人坦克向量交给该敌人坦克
				//Give EnemyTank vector in MyPanel2 to EnemyTank 
				et.setEts(ets);
				
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
		}else {
			nodes = new Recorder().getNodesAndEnNums();
			//Initialize enemy's tanks
			for (int i = 0; i<nodes.size() ; i++)
			{
				Node node = nodes.get(i);
				//Create an enemy's tank 
				EnemyTank et = new EnemyTank(node.x,node.y);
				et.setColor(0);
				et.setDirect(node.direct);
				//将MyPanel的敌人坦克向量交给该敌人坦克
				//Give EnemyTank vector in MyPanel2 to EnemyTank 
				et.setEts(ets);
				
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
	
	//Draw the tank lives information
	public void showInfo(Graphics g)
	{
		this.drawTank(700, 100, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+" ", 750, 120);
		
		this.drawTank(700, 150, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMyLife()+" ", 750, 170);
	
	//show the score of the player
		g.setColor(Color.black);
		Font f = new Font("宋体",Font.BOLD,20);
		g.setFont(f);
		g.drawString("Your score is: 	", 700, 220);
	
		//this.drawTank(800, 220, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+" ", 880	, 220);
	}
	
	
	//repaint
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 600, 600);
		
		//Draw tank lives(not for the battle)
		this.showInfo(g);
		
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
						if(this.hitTank(myShot, et))
						{
							Recorder.reduceEnNum();
							Recorder.addEnNumRec();
						}
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
				if(hero.isLive)
				{
					if(this.hitTank(enemyShot, hero))
					{
						
					}
				}
			}
		}
	}
	
	//Create a function to tell whether the bullet hit the enemies
	public boolean hitTank(Shot s, Tank et)
	{
		boolean b2 = false;
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
				b2 = true;
				
//				Recorder.reduceEnNum();
//				Recorder.addEnNumRec();
				//create a bomb, put into the vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);
				
			}
			break;
		case 2:
		case 3:
			if(s.x>=et.x &&s.x<=et.x+30&&s.y>=et.y&&s.y<=et.y+20)
			{
				//been hit
				//the bullet died
				s.isLive=false;
				//the enemy tank died
				et.isLive = false;
				b2=true;
//				Recorder.reduceEnNum();
//				Recorder.addEnNumRec();
				//create a bomb, put into the vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);
			}
		
		}
		return b2;
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


