/*
 * File��Ļ����÷�
 */
package com.hanshunping44;
import java.io.*;
public class Demo11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	File f = new File("e:\\Yo.txt");
		//�õ��ļ�·��
		System.out.println("�ļ�·�� "+f.getAbsolutePath());
		//�õ��ļ����ֽڴ�С
		System.out.println("�ļ���С "+f.length()+" Byte");
		System.out.println("�ɶ�"+f.canRead());
		System.out.println("��ִ��"+f.canExecute());
		*/
		//�����ļ������ļ���
	
		/*File f = new File("e:\\help.mp3");
		 if(!f.exists())
		 {
			 //���Դ���
			 try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else {
			 System.out.println("���ļ������ܱ�����");
		 }
	}
	*/
	// File ff = new File("e:\\ff");
	File f = new File("e:\\movies");
	if(f.isDirectory())
	{
		File lists[] = f.listFiles();
		for(int i = 0; i <lists.length;i++)
		{
			System.out.println("The names are "+ lists[i].getName());
		}
		}

	}
}