/*
 * 演示FileInputStream类的使用
 */
package com.hanshunping44;
import java.io.*;
public class Demo11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("e:\\Yo.txt");
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(f);
			//定义一个字节数组
			byte []bytes = new byte[1024];
			int n =0;
			while((n=fis.read(bytes))!=-1)
			{
				System.out.println("n is "+n);
				//把字节转成string
				String s = new String(bytes,0,n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
