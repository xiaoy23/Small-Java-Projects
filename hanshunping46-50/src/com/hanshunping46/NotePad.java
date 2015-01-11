/*
 * 我的记事本（界面-功能）
 */
package com.hanshunping46;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener {

	//定义需要的组件
	JTextArea jta = null;
	//菜单条
	JMenuBar jmb = null;
	//第一JMenu
	JMenu jm1 =null;
	JMenuItem jmi1,jmi2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad notepad = new NotePad();
	}
	//构造函数
	public NotePad()
	{
		//创建jta
		jta = new JTextArea();
		jmb = new JMenuBar();
		jm1= new JMenu("Open(O)");
		//设置助记符
		jm1.setMnemonic('F');
		jmi1 =  new JMenuItem("Open",new ImageIcon("26.jpg"));
		jmi2 = new JMenuItem("Save");
		
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("Open");
		
		//对保存菜单的处理
		jmi2.addActionListener(this);
		jmi2.setActionCommand("Save");
		//加入
		this.setJMenuBar(jmb);
		//把jm1放入jmb
		jmb.add(jm1);
		//把Item放入Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		//放入JFrame
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setVisible(true);
		
	}
	
	//
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断是哪个菜单被选中
		if(arg0.getActionCommand().equals("Open"))
		{
			//System.out.println("OPEN!");
		
			//隆重推出JFileChooser
			//文件选择组件
			JFileChooser jfc1 = new JFileChooser();
			jfc1.setDialogTitle("Please select a file...");
			//默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//得到用户选择的文件路径
			String filename = jfc1.getSelectedFile().getAbsolutePath();
		//	System.out.println(filename);
			FileReader fr = null;
			BufferedReader  br = null;
			try{
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
				
				//从文件中读取信息并显示到jta
				String s = "";
				String allCon = "";
				while((s = br.readLine())!=null)
				{
					allCon += s+"\r\n";
				}
				//跳出循环时放入jta即可
				jta.setText(allCon);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}else if(arg0.getActionCommand().equals("Save"))
		{
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Save as...");
			//按默认方式显示
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			//得到用户希望把文件保存到何处，文件全路径
			String file = jfc.getSelectedFile().getAbsolutePath();
			//准备写入到指定文件
			FileWriter fw = null;
			BufferedWriter bw = null;
			try{
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				//此处可以优化
				bw.write(this.jta.getText());
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					bw.close();
					fw.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
}
