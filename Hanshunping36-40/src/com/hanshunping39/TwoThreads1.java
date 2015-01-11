package com.hanshunping39;

public class TwoThreads1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig = new Pig(10);
		Bird bird = new Bird(10);
		Thread t1 = new Thread(pig);
		Thread t2 = new Thread(bird);
		t1.start();
		t2.start();
	}

}
class Pig implements Runnable
{
	int n =0;
	int times = 0;
	public Pig(int n )
	{this.n = n;}
	public void run(){
	{
	  while(true)
	  {
		  try{Thread.sleep(1000);}
		  catch(Exception e)
		  {
			  
		  }
		  times++;
		  System.out.println("I'm a Thread, printing the "+ times + "Hello World");
		  if(times ==n)
		  {
			  break;
		  }
	  
	  }
	  }
		
	}
}

class Bird implements Runnable
{

	int n= 0;
	int res = 0;
	int times = 0;
	public Bird(int n)
	{
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){	
			}
			res+=(++times);
			System.out.println("The current result is "+res);
			if(times ==n)
			{
				System.out.println("the final result is "+res);
				break;
			}
		}
	}
	
}