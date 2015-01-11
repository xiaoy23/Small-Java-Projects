/*
 * 图片copy
 */
package com.hanshunping45;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo11_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//思路：先把图片读入到内存->写入到某个文件
		//图片是二进制文件，只能用字节流去完成
		//File f1 = new File();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("c:\\a.jpg");
			fos = new FileOutputStream("d:\\a.jpg");
			byte []buf = new byte[512];
			//循环读取，因为并不知道图片有多大
			int n = 0;//实际读取到的字节数
			while((n = fis.read(buf)) != -1)
			{
				//输出到指定文件
				fos.write(buf);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				fis.close();
				fos.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
