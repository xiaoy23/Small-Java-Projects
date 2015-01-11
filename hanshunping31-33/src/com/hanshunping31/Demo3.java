package com.hanshunping31;
import java.awt.*;

import javax.swing.*;
public class Demo3 extends JFrame{

	//Define components
	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb1;
	JList jlist;
	JScrollPane jsp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo3 dm3 = new Demo3();
	}
	
	public Demo3(){
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jlb1 = new JLabel("Nationality");
		jlb2 = new JLabel("Travelling to");
		
		//To create JComboBox
		String [] Nn = {"Korean","Canadian","Chinese"};
		jcb1 = new JComboBox(Nn);
		
		String [] places = {"Cuba","China","USA","Russia"};
		jlist = new JList(places);
		//设置你希望显示多少个选项
		jlist.setVisibleRowCount(3);
		jsp = new JScrollPane(jlist);
		

		
		
		this.setLayout(new GridLayout(3,1));
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp2.add(jlb2);
		jp2.add(jsp);
		this.add(jp1);
		this.add(jp2);
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
