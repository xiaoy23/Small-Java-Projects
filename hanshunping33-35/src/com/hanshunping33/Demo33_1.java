/*
 * ���ܣ�java��ͼԭ��
 */
package com.hanshunping33;
import javax.swing.*;
import java.awt.*;

public class Demo33_1 extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Demo33_1 dm = new Demo33_1();
	}
		public Demo33_1()
		{
			MyPanel mp = new MyPanel();
			this.add(mp);
			this.setSize(400,300);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
}

class MyPanel  extends JPanel
{
	//override JPanel Paint method
	//Graphics �ǻ�ͼ����Ҫ�࣬��������һ֧����
	public void paint(Graphics g)
	{
		//1.���ø��ຯ������ɳ�ʼ������
		super.paint(g);
		System.out.println("Paint ���������á�");
		//��仰������
		//�Ȼ�һ��ԲȦ
//		g.setColor(Color.blue);
		g.drawOval(200, 100, 30, 30);
		Image im = Toolkit.getDefaultToolkit().getImage
				(Panel.class.getResource("/247056.jpg"));
		g.drawImage(im, 90, 90, 200, 150, this);
		g.setColor(Color.yellow);
		g.setFont(new Font("Times New Roman",Font.BOLD,50));
		g.drawString("Keep calm and be RICH!!!", 500, 300);
	}
}
