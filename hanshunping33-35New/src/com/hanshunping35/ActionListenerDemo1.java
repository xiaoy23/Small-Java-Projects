/*
 * 时间处理机制的讲解
 *
 */
package com.hanshunping35;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ActionListenerDemo1 extends JFrame implements ActionListener {

	JPanel mp = null;
	JButton jb1 = null;
	JButton jb2 = null;
	Cat cat1 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListenerDemo1  demo = new ActionListenerDemo1();
		
	}
	public ActionListenerDemo1()
	{
		mp = new JPanel();
		jb1 = new JButton("Black");
		jb2 = new JButton("Red");
		cat1 = new Cat();
		
		this.add(mp);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		
		//注册监听
		//这个this 代表的 demo 这个对象，而不是ActionListenerDemo 这个类
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb1.addActionListener(cat1);
		jb2.addActionListener(cat1);
		
		//制定action 命令
		jb1.setActionCommand("The Black One");
		jb2.setActionCommand("The Red One");
	
		
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//对事件处理的方法
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个按钮被监听
		if (e.getActionCommand().equals("The Black One"))
		{
			System.out.println("You pressed the 'Black' Button");
			mp.setBackground(Color.black);
		}
		else if (e.getActionCommand().equals("The Red One"))
		{
			System.out.println("You pressed the 'Red' Button");
			mp.setBackground(Color.red);
		}
		else{
			System.out.println("I don't know");
		}
	}
	
}


class Cat implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("The Black One"))
		{
			System.out.println("The Cat knows you pressed the Black Button");
		}
		else if(e.getActionCommand().equals("The Red One"))
		{
			System.out.println("The Cat knows you pressed the red Button");
		}
		else{
			System.out.println("He doesen't care");
		}
	}
	
}
/*class MyPanel3 extends JPanel
{
	public void paint(Graphics g){
		super.paint(g);
	}
}
*/
