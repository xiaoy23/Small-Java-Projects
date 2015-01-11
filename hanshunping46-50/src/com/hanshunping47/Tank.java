package com.hanshunping47;

import java.util.Vector;



public class Tank
{
	//The horizontal axis of the tank
	int x = 0;
	int y= 0;
	//Define the direction of the tanks
	//0 up , 1 down , 2 left , 3 right
	int direct = 0;
	int color;
	boolean isLive = true;
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	//Set the HeroSpeed of the tank
	int HeroSpeed = 1;
	
	
	public int getHeroSpeed() {
		return HeroSpeed;
	}
	public void setHeroSpeed(int HeroSpeed) {
		this.HeroSpeed = HeroSpeed;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
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
	//The bullets belong to Hero
	Shot s = null;
	Vector<Shot> ss = new Vector<Shot>();
	public int HeroSpeed = 5;
	
	
	
	public Hero(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
	
	}
	//Tank shots
	public void shotEnemy()
	{
		
		switch(this.direct)
		{
		case 0:
			s= new Shot(x+10,y,0);
			ss.add(s);
			break;
		case 3:
			s = new Shot(x +30,y+10,3);
			ss.add(s);
			break;
		case 1:
			s = new Shot(x + 10,y +30,1);
			ss.add(s);
			break;
		case 2:
			s = new Shot(x , y+10,2);
			ss.add(s);
			break;
		}
		//Start the bullet Thread
		Thread t = new Thread(s);
		t.start();
	}
	
	//Tank moves up
	public void movingup()
	{
		y = y - HeroSpeed;
	}
	//Tank moves right
	public void movingright()
	{
		x = x + HeroSpeed;
	}
	public void movingdown()
	{
		y = y + HeroSpeed;
	}
	public void movingleft()
	{
		x = x - HeroSpeed;
	}
}