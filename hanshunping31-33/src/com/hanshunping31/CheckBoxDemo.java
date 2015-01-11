package com.hanshunping31;
import java.awt.*;
import javax.swing.*;

public class CheckBoxDemo extends JFrame {
	//define components
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBoxDemo dm2 = new CheckBoxDemo();
	}
	
	public CheckBoxDemo(){
		
		super("Check Box Model");
		//create components
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("Your Favorite Sports");
		jlb2 = new JLabel("Your Gender");
		jb1 = new JButton("Register");
		jb2 = new JButton("Cancel");
		
		jcb1 = new JCheckBox("Soccer");
		jcb2 = new JCheckBox("Basketball");
		jcb3 = new JCheckBox("Tennis");
		
		jrb1 = new JRadioButton("Male");
		jrb2 = new  JRadioButton("Female");
		
		//Don't forget to put JRadioButtons into JButtonGroup
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//set the Layout of the JFrame
		this.setLayout(new GridLayout(3,1));
		
		//add components into each JPanel
		
		jp1.setLayout(new FlowLayout());
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.setLayout(new FlowLayout());
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,150);
		this.setLocation(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
