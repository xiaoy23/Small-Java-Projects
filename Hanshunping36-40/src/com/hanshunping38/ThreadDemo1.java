/*
 * ��ʾ���ͨ���̳�Thread�������߳�
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
			//����һ��
			//1000 ��ʾ 1000����
			//sleep �ͻ��ø��߳̽��뵽Blocked״̬�����ͷ���Դ
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