/*
 * Java ��ͼԭ��
 */

package com.hanshunping33;
import java.awt.*;
import javax.swing.*;

public class Demo9_1 extends JFrame {

	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo9_1 demo1 = new Demo9_1();
	}
	
	public Demo9_1()
	{
		mp = new MyPanel();
		this.add(mp);
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//����һ��Mypanel
class MyPanel extends JPanel
{
	//����JPanel ��paint ����
	//Graphics �ǻ�ͼ����Ҫ�࣬����԰�������һ֧����
	public void paint(Graphics g)
	{
		//���ø��ຯ������ɳ�ʼ������
		super.paint(g);
		g.drawOval(30,50,30, 30);
		System.out.println(" 'Paint()' ������");
		g.drawLine(50, 500, 200, 500);
		g.setColor(Color.red);
		g.fillRect(10, 10, 40, 60);
		g.setColor(Color.blue);
		g.fillRect(70, 70, 40, 60);
		
		Image im = Toolkit.getDefaultToolkit().
				getImage(Panel.class.getResource("/247056.jpg"));
		g.setColor(Color.red);
		g.setFont(new Font("���Ĳ���",Font.BOLD,50));
		g.drawString("�������������ţ�",500,500);
	//�û��ʻ���ͼ��
		g.drawImage(im, 90, 90, 200, 200,this);
	}
}