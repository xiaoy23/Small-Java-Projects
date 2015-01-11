package com.hanshunping41;

public class Bomb {

	//Define the coordination of the bomb
	int x,y;
	int life = 9;
	boolean isLive = true;
	
	public Bomb(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//health goes down
	public void lifedown()
	{
		if(life>0)
		{
			life--;
		}else{
			this.isLive = false;
		}
	}
	
}
