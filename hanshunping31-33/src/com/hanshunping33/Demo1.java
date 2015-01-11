package com.hanshunping33;

import java.awt.*;
import javax.swing.*;

public class Demo1 extends JFrame {

	MyPanel mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 dm = new Demo1();
	}

	public Demo1(){
		mp = new MyPanel();
		this.add(mp);
		
		this.setSize(600,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


//Define MyPanel as my own panel to display the graphics 
class MyPanel extends JPanel{
	//override
	//Graphics is a important class in painting ,can be regarded as a pen
	public void paint(Graphics g)
	{
		//1.call its father to initialize
		super.paint(g);//this is a very important call
		//draw a circle
		g.drawOval(200, 200, 30, 30);
		System.out.println("This method has been called once");
		g.setColor(Color.blue);
		
		g.draw3DRect(100, 100, 20, 20, true);
		g.setColor(Color.red);
		g.fillRect(500, 350, 20, 20);
		
		
	}
}