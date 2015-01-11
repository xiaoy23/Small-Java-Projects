/*
 * ʱ�䴦����ƵĽ���
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
		
		//ע�����
		//���this ����� demo ������󣬶�����ActionListenerDemo �����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb1.addActionListener(cat1);
		jb2.addActionListener(cat1);
		
		//�ƶ�action ����
		jb1.setActionCommand("The Black One");
		jb2.setActionCommand("The Red One");
	
		
		this.setSize(400,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//���¼�����ķ���
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж����ĸ���ť������
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
