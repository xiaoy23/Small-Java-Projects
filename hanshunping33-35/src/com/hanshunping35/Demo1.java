/*
 * ���ܣ��¼��������
 */
package com.hanshunping35;
import javax.swing.*;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Demo1 extends JFrame implements ActionListener{

	MyPanel mp = null;
	JButton jb1,jb2,jb3= null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 demo1 = new Demo1();
	}

	public Demo1()
	{
		Yuchen yuchen = new Yuchen();
		mp = new MyPanel();
		jb1 = new JButton("Black");
		jb2 = new JButton("Red");
		jb3 = new JButton("Test Button");
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.add(jb3,BorderLayout.EAST);
		this.add(mp);
		mp.setBackground(Color.black);
		
		//ע�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb1.addActionListener(yuchen);
		jb2.addActionListener(yuchen);
		jb3.addActionListener(yuchen);
		//ָ��action����
		jb1.setActionCommand("��ɫ");
		jb2.setActionCommand("��ɫ");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	//���¼�����ķ���
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж��ĸ���ť�����
		if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("You pressed the \"Black\" button");
			mp.setBackground(Color.black);
		}
		else if (e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("You pressed the \"Red\" button");
			mp.setBackground(Color.red);
		}
		else {System.out.println("I don't know !");
		}
	}

}

class MyPanel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);
		
	}
	
}
class Yuchen implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("Yuchen knows that you pressed black button");
		}
		else 
		{
			System.out.println("WTF Yuchen knows what you are doing!");
		}
	}
}
