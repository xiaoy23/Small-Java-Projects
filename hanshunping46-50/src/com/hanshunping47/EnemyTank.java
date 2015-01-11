package com.hanshunping47;

import java.util.Vector;

class EnemyTank extends Tank implements Runnable{
	
	private int EnemySpeed = 2;
	 //Define a vector to store enemy's bullet
	 Vector<Shot> ss = new Vector<Shot>();
	 //The bullet is loaded when an Enemy's tank is created or when an enemy's bullet is dead
	 
	public EnemyTank(int x,int y)
	{
		super(x, y);
	}
	//Define a vector which can visit all Enemy tanks in  MyPanel
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	
	//得到MyPanel的敌人坦克向量
	public void setEts(Vector<EnemyTank>vv)
	{
		this.ets = vv;
	}
	//To determine whether it collide with other Enemytanks
	public boolean isTouchOtherEnemy()
	{
		boolean b = false;
		
		switch(this.direct)
		{
		case 0:
			//My tank going up
			//get out all enemy tanks
			for(int i = 0;i<ets.size();i++)
			{
				//get first tank
				EnemyTank et = ets.get(i);
				//If not myself
				if(et!=this)
				{
					//If enemy tanks going up/down
					if(et.direct==0||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{ 
							return true;
						}	
					}
					//If Enemy going left and right
					if(et.direct ==2||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y>=et.y&&this.y<=et.y+20)
						{
							return true;
						}	
					}
				}
				
			}
			break;
		case 1:
			//My tank going down
			//get out all enemy tanks
			for(int i = 0;i<ets.size();i++)
			{
				//get first tank
				EnemyTank et = ets.get(i);
				//If not myself
				if(et!=this)
				{
					//If enemy tanks going up/down
					if(et.direct==0||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{ 
							return true;
						}	
					}
					if(et.direct ==2||et.direct==3)
					{
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}
						if(this.x+20>=et.x&&this.x+20<=et.x+30&&this.y+30>=et.y&&this.y+30<=et.y+20)
						{
							return true;
						}	
					}
				}
			}
			break;
		case 2:
			//My tank going left
			//get out all enemy tanks
			for(int i = 0;i<ets.size();i++)
			{
				//get first tank
				EnemyTank et = ets.get(i);
				//If not myself
				if(et!=this)
				{
					//If enemy tanks going up/down
					if(et.direct==0||et.direct==1)
					{
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+20&&this.y>=et.y&&this.y<=et.y+30)
						{ 
							return true;
						}	
					}
					if(et.direct ==2||et.direct==3)
					{
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
						if(this.x>=et.x&&this.x<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}	
					}
				}
			}
			break;
		case 3:
			//My tank going right
			//get out all enemy tanks
			for(int i = 0;i<ets.size();i++)
			{
				//get first tank
				EnemyTank et = ets.get(i);
				//If not myself
				if(et!=this)
				{
					//If enemy tanks going up/down
					if(et.direct==0||et.direct==1)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+30>=et.y&&this.y<=et.y+30)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+20&&this.y+30>=et.y&&this.y+30<=et.y+30)
						{ 
							return true;
						}	
					}
					if(et.direct ==2||et.direct==3)
					{
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}
						if(this.x+30>=et.x&&this.x+30<=et.x+30&&this.y+20>=et.y&&this.y+20<=et.y+20)
						{
							return true;
						}	
					}
				}
				
			}
			break;
		
		}
		return b;
	
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
						y-=EnemySpeed;
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
					if(y<300)
					{
						y+=EnemySpeed;
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
						x -=EnemySpeed;
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
					if(x<400)
					{
						x+=EnemySpeed;
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
