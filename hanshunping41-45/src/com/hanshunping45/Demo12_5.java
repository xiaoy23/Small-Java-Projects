/*
 * ��ʾ�ļ��ַ����İ���
 */
package com.hanshunping45;

import java.io.FileReader;
import java.io.FileWriter;

public class Demo12_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ļ�ȡ���ַ�������
		FileReader fr = null;
		//д�뵽�ļ����������
		FileWriter fw = null;
		
		try{
			//����fr����
			fr = new FileReader("c:\\test.txt");
			fw = new FileWriter("d:\\test.txt");
			//���뵽�ڴ�
			char c[] = new char[1024];
			//��¼��ȡ�����ַ���
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
