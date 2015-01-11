/*
 * 演示如何通过继承Thread来开发线程
 */
package com.hanshunping38;

public class ThreadDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		//Start the Thread
		cat.start();
	}

}

class Cat extends Thread
{
	//Rewrite run
	public void run()
	{
		for(int i = 0;i< 10;i++)
		{
			//休眠一秒
			//1000 表示 1000毫秒
			//sleep 就会让该线程进入到Blocked状态，并释放资源
			if(i< 10){
			try {
				Thread.sleep(100);;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello, world" + (i+1) + "times");
			
		}
		}
		}
}