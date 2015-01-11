package com.hanshunping41;

import java.util.Vector;

class EnemyTank extends Tank implements Runnable{
	
	 //Define a vector to store enemy's bullet
	 Vector<Shot> ss = new Vector<Shot>();
	 //The bullet is loaded when an Enemy's tank is created or when an enemy's bullet is dead
	 
	public EnemyTank(int x,int y)
	{
		super(x, y);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(50);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			switch(this.direct)
			{
			case 0:
				//Tank going up
				for(int i = 0;i<10;i++)
				{
					if(y>0)
					{	
						y-=speed;
					}
					try{
						Thread.sleep(50);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				break;
			case 1:
				//Tank going down
				for(int i = 0;i<10;i++)
				{
					if(y<600)
					{
						y+=speed;
					}
					try{
						Thread.sleep(50);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				break;
			case 2:
				//Tank going left
				for(int i = 0;i<10;i++)
				{
					if(x>0)
					{
						x -=speed;
					}
					try{
						Thread.sleep(50);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				
				break;
			case 3:
				//tank going right
				for(int i = 0;i<10;i++)
				{
					if(x<600)
					{
						x+=speed;
					}
					try{
						Thread.sleep(50);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				break;
			}
			
		//Make tank move randomly(make random decisions about direction)
			this.direct  = (int)(Math.random() *4);
		//Decide whether Enemy tank is live or not
			if(this.isLive == false)
			{
				//When tank dies, exit the thread
				break;
			}

		}
	}
}
