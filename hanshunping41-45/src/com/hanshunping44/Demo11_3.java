/*
 * ��ʾFileOutputStream
 */
package com.hanshunping44;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo11_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("e:\\ww.txt");
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(f);
			String s = "Vincent wants to be expertise at software engineering.\r\n";
			String s1 = "The best of the bests !!";
			//byte []bytes = new byte[2014];
			//��ΰ�String->bytes����
			//fos.write(bytes);
			fos.write(s.getBytes());
			fos.write(s1.getBytes());
			
		}catch(Exception e){
			
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
