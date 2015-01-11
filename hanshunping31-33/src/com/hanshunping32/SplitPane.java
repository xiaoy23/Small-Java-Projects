package com.hanshunping32;
import java.awt.*;
import javax.swing.*;
public class SplitPane extends JFrame{
	//Define components
	JSplitPane jsp;
	JList jlist;
	JLabel jlb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitPane sp = new SplitPane();
	}
	
	public SplitPane(){
		//Create components
		String [] words = {"birds","cat","butter","psyche"};
		jlist = new JList(words);
		jlb = new JLabel(new ImageIcon("Images/huoying.jpg"));
		//拆分窗格
		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jlb);
		//可以伸缩
		jsp.setOneTouchExpandable(true);
		//set Layout
		
		//add components
		this.add(jsp);
		
		this.setSize(400,300);
		this.setLocation(200,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
