/*
 * ͼƬcopy
 */
package com.hanshunping45;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo11_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//˼·���Ȱ�ͼƬ���뵽�ڴ�->д�뵽ĳ���ļ�
		//ͼƬ�Ƕ������ļ���ֻ�����ֽ���ȥ���
		//File f1 = new File();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("c:\\a.jpg");
			fos = new FileOutputStream("d:\\a.jpg");
			byte []buf = new byte[512];
			//ѭ����ȡ����Ϊ����֪��ͼƬ�ж��
			int n = 0;//ʵ�ʶ�ȡ�����ֽ���
			while((n = fis.read(buf)) != -1)
			{
				//�����ָ���ļ�
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
