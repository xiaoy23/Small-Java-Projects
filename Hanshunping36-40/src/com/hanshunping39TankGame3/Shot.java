package com.hanshunping39TankGame3;

public class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed = 3;
	public Shot(int x, int y,int direct)
	{
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(50);
			}catch(Exception e){
				
			}
			switch(direct)
			{
			//Bullet goes up
			case 0:
				y-= speed;
				break;
			case 3:
				x+=speed;
				break;
			case 1:
				y+=speed;
				break;
			case 2:
				x -=speed;
				break;
			}
			System.out.println("The location of the bullet: x = "+x+"y ="+ y);
			//When does the bullet die?
			//Whether the bullet is dead
			if(x<0||x>600||y<0||y>600)
			{
				break;
			}
		}
	}
	
}
