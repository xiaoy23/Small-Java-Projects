package com.hanshunping32;
import java.awt.*;
import javax.swing.*;

public class QQChatBox extends JFrame{

	JTextArea jta;
	JPanel jp1;
	JComboBox jcb;
	JTextField jtf;
	JButton jb;
	JScrollPane jsp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQChatBox qq = new QQChatBox();
	}

	public QQChatBox(){
		
		jta = new JTextArea();
		jp1 = new JPanel();
		String [] chatters = {"Justin","Jordon","Jack","David"};
		jcb  = new JComboBox(chatters);
		jb = new JButton("Send");
		jtf = new JTextField(10);
		jsp = new JScrollPane(jta);
		
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb);
		
		this.add(jsp);
		this.add(jp1,BorderLayout.SOUTH);
		this.setSize(300,200);
		this.setIconImage((new ImageIcon("Images/qqicon.png")).getImage());
		this.setTitle("Tencent QQ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	} 
}
