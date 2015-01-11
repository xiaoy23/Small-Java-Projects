package com.hanshunping35;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ActionListenerDemo2 extends JFrame  {

	MyPanel3 mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListenerDemo2 demo2 = new ActionListenerDemo2();
	}

	public ActionListenerDemo2(){
		mp = new MyPanel3();
		this.setSize(400,500);
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}

class MyPanel3 extends JPanel implements KeyListener{
	private int x = 10;
	private int y = 10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			y = y +5;
		}else if (arg0.getKeyCode()==KeyEvent.VK_UP)
		{
			y = y - 5;
		}else if (arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x = x - 5;
		}else if (arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x = x +5;
		}
		//调用repaint() 函数
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//键的一个值被输出
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
/*
 * 一个类要实现坚挺的几个步骤
 * 1.实现相应的接口：KeyListener,MouseListener,ActionListener,WindowListener,etc
 * 2.把接口的处理方法根据需要重新编写
 * 3.在事件源上注册监听
 * 4.事件传递是靠事对象（ActionEvent ,etc）
*/