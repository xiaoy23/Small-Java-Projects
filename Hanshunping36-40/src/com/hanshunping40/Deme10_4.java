/*
 * 使用线程的注意事项
 */
package com.hanshunping40;

public class Deme10_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cat cat1 = new Cat();
		cat1.start();*/
		Dog dog1 = new Dog();
		Thread t1 = new Thread(dog1);
		Thread t2 = new Thread(dog1);
		t1.start();
		t2.start();
		
	}

}

//猫类
class Cat extends Thread
{
	public void run()
	{
		System.out.println("11");
		
	}
}

class Dog implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("22");
	}

	
}