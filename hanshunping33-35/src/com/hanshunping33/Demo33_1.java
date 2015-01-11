/*
 * 功能：java绘图原理
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
	//Graphics 是绘图的重要类，可以理解成一支画笔
	public void paint(Graphics g)
	{
		//1.调用父类函数，完成初始化任务
		super.paint(g);
		System.out.println("Paint 方法被调用。");
		//这句话不能少
		//先画一个圆圈
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
