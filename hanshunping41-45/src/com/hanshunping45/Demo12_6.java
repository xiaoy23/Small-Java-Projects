/*
 * ��ʾ�����ַ���
 */
package com.hanshunping45;
import java.io.*;
public class Demo12_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			//�ȴ���һ��FileReader����
			FileReader fr = new FileReader("c:\\test.txt");
			br = new BufferedReader(fr);
			
			//����filewriter
			FileWriter fw = new FileWriter("d:\\����.txt");
			bw = new BufferedWriter(fw);
			String s="";
			//ѭ����ȡ
			while((s = br.readLine())!=null)
			{
				//System.out.print(s);
				//���������
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
