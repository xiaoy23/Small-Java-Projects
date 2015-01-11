/*
 * 演示缓冲字符流
 */
package com.hanshunping45;
import java.io.*;
public class Demo12_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			//先创建一个FileReader对象
			FileReader fr = new FileReader("c:\\test.txt");
			br = new BufferedReader(fr);
			
			//创建filewriter
			FileWriter fw = new FileWriter("d:\\晨曦.txt");
			bw = new BufferedWriter(fw);
			String s="";
			//循环读取
			while((s = br.readLine())!=null)
			{
				//System.out.print(s);
				//输出到磁盘
				bw.write(s+"\r\n");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				br.close();
				bw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
