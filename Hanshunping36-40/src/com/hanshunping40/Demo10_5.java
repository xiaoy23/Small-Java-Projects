package com.hanshunping40;

public class Demo10_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义三个售票窗口
		TicketWindow tw1 = new TicketWindow();
		//TicketWindow tw2 = new TicketWindow();
		//TicketWindow tw3 = new TicketWindow();
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
//售票窗口
class TicketWindow implements Runnable{
	//一共两千张票
	private int nums = 20;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
		
			
			//先判断是否还有票卖
			//认为if else 要保证其原子性
			synchronized(this){
			if(nums > 0)
			{
				//显示售票信息
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Thread.currentThread().getName()
				System.out.println(Thread.currentThread().getName()+"正在售出第"+nums+ "票");
				nums--;
			}
			else
			{	
				//售票结束
				break;
			}
		}
		}
	}
	
	
}