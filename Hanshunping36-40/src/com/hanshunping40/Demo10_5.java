package com.hanshunping40;

public class Demo10_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����������Ʊ����
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
//��Ʊ����
class TicketWindow implements Runnable{
	//һ����ǧ��Ʊ
	private int nums = 20;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
		
			
			//���ж��Ƿ���Ʊ��
			//��Ϊif else Ҫ��֤��ԭ����
			synchronized(this){
			if(nums > 0)
			{
				//��ʾ��Ʊ��Ϣ
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Thread.currentThread().getName()
				System.out.println(Thread.currentThread().getName()+"�����۳���"+nums+ "Ʊ");
				nums--;
			}
			else
			{	
				//��Ʊ����
				break;
			}
		}
		}
	}
	
	
}