package com.hanshunping47;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyStartPanel extends JPanel implements Runnable {
	int times = 0;
	public void paint(Graphics g)
	{
		
		super.paint(g);
		g.fillRect(0, 0, 800, 600);
		if(times%2==0){
		g.setColor(Color.yellow);
		Font myFont = new Font("»ªÎÄÐÂÎº",Font.BOLD,30);
		g.setFont(myFont);
		
		g.drawString("Stage: 1", 230, 250);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(100);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			times++;
			//repaint
			this.repaint();
		}
	}
}
