/*
 * 演示文件字符流的案例
 */
package com.hanshunping45;

import java.io.FileReader;
import java.io.FileWriter;

public class Demo12_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//文件取出字符流对象
		FileReader fr = null;
		//写入到文件（输出流）
		FileWriter fw = null;
		
		try{
			//创建fr对象
			fr = new FileReader("c:\\test.txt");
			fw = new FileWriter("d:\\test.txt");
			//读入到内存
			char c[] = new char[1024];
			//记录读取到的字符数
			int n = 0;
			while((n =fr.read(c))!= -1)
			{
//				String s = new String(c,0,n);
//				System.out.println(c);
				fw.write(c, 0, n);
			}
		}catch(Exception e )
		{
			e.printStackTrace();
		}finally{
			try{
				fr.close();
				fw.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
