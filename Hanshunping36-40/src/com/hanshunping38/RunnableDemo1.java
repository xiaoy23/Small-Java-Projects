package com.hanshunping38;

public class RunnableDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		//�ȴ���һ���̶߳��󣬰ѹ��������Ž�ȥ
		Thread t = new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int times = 1;
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello,world"+times + " times ");
			times++;
			if(times >10)
			{
				break;
			}
		}
	}
	
}