package com.hanshunping31;
import java.awt.*;
import javax.swing.*;
public class LoginSystemDemo extends JFrame{
	//Define components
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JTextField jtf1,jtf2;
	JPasswordField jpf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginSystemDemo demo1 = new LoginSystemDemo();
	}
	public LoginSystemDemo(){
		super("Mcmaster Login System");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("User Name: ");
		jlb2 = new JLabel("   Password:");
		jb1 = new JButton("Login in");
		jb2 = new JButton("Cancel");
		
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		
		//set Layout
		this.setLayout(new GridLayout(3,1));
		//add each components
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jtf2);
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
