/*
 * �ҵļ��±�������-���ܣ�
 */
package com.hanshunping46;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener {

	//������Ҫ�����
	JTextArea jta = null;
	//�˵���
	JMenuBar jmb = null;
	//��һJMenu
	JMenu jm1 =null;
	JMenuItem jmi1,jmi2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad notepad = new NotePad();
	}
	//���캯��
	public NotePad()
	{
		//����jta
		jta = new JTextArea();
		jmb = new JMenuBar();
		jm1= new JMenu("Open(O)");
		//�������Ƿ�
		jm1.setMnemonic('F');
		jmi1 =  new JMenuItem("Open",new ImageIcon("26.jpg"));
		jmi2 = new JMenuItem("Save");
		
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("Open");
		
		//�Ա���˵��Ĵ���
		jmi2.addActionListener(this);
		jmi2.setActionCommand("Save");
		//����
		this.setJMenuBar(jmb);
		//��jm1����jmb
		jmb.add(jm1);
		//��Item����Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		//����JFrame
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setVisible(true);
		
	}
	
	//
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//�ж����ĸ��˵���ѡ��
		if(arg0.getActionCommand().equals("Open"))
		{
			//System.out.println("OPEN!");
		
			//¡���Ƴ�JFileChooser
			//�ļ�ѡ�����
			JFileChooser jfc1 = new JFileChooser();
			jfc1.setDialogTitle("Please select a file...");
			//Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ�·��
			String filename = jfc1.getSelectedFile().getAbsolutePath();
		//	System.out.println(filename);
			FileReader fr = null;
			BufferedReader  br = null;
			try{
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
				
				//���ļ��ж�ȡ��Ϣ����ʾ��jta
				String s = "";
				String allCon = "";
				while((s = br.readLine())!=null)
				{
					allCon += s+"\r\n";
				}
				//����ѭ��ʱ����jta����
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
			//��Ĭ�Ϸ�ʽ��ʾ
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			//�õ��û�ϣ�����ļ����浽�δ����ļ�ȫ·��
			String file = jfc.getSelectedFile().getAbsolutePath();
			//׼��д�뵽ָ���ļ�
			FileWriter fw = null;
			BufferedWriter bw = null;
			try{
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				//�˴������Ż�
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
