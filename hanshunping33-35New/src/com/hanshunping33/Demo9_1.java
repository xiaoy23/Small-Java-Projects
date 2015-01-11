/*
 * Java 绘图原理
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

//定义一个Mypanel
class MyPanel extends JPanel
{
	//覆盖JPanel 的paint 方法
	//Graphics 是绘图的重要类，你可以把他理解成一支画笔
	public void paint(Graphics g)
	{
		//调用父类函数，完成初始化任务
		super.paint(g);
		g.drawOval(30,50,30, 30);
		System.out.println(" 'Paint()' 被调用");
		g.drawLine(50, 500, 200, 500);
		g.setColor(Color.red);
		g.fillRect(10, 10, 40, 60);
		g.setColor(Color.blue);
		g.fillRect(70, 70, 40, 60);
		
		Image im = Toolkit.getDefaultToolkit().
				getImage(Panel.class.getResource("/247056.jpg"));
		g.setColor(Color.red);
		g.setFont(new Font("华文彩云",Font.BOLD,50));
		g.drawString("丁晓曦是我老婆！",500,500);
	//用画笔画出图像
		g.drawImage(im, 90, 90, 200, 200,this);
	}
}