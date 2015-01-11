/*
 * File类的基本用法
 */
package com.hanshunping44;
import java.io.*;
public class Demo11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	File f = new File("e:\\Yo.txt");
		//得到文件路径
		System.out.println("文件路径 "+f.getAbsolutePath());
		//得到文件的字节大小
		System.out.println("文件大小 "+f.length()+" Byte");
		System.out.println("可读"+f.canRead());
		System.out.println("可执行"+f.canExecute());
		*/
		//创建文件或者文件夹
	
		/*File f = new File("e:\\help.mp3");
		 if(!f.exists())
		 {
			 //可以创建
			 try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else {
			 System.out.println("有文件，不能被创建");
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