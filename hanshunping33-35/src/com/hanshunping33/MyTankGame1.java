package com.hanshunping33;
import javax.swing.*;
import java.awt.*;
public class MyTankGame1 extends JFrame {
       
	MyPanel2 mp = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame1 mtg = new MyTankGame1();
	}
//���캯��
	public MyTankGame1(){
		mp = new MyPanel2();
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyPanel2 extends JPanel{
	//����һ���ҵ�tank
	Hero hero=null;
	//���캯��
	public MyPanel2(){
		hero = new Hero(10,10);
	}
	//��дpaint()����
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//�����ҵ�Tank����ʱ�ٷ�װ��һ��������
		//1.������ߵľ���
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, 0, 1);
	}
	
	//��װ��˼�룬���½�һ������tank�ĺ���
	public void drawTank(int x ,int y,Graphics g,int direction,int type){
		switch(type){
		case 0:
			g.setColor(Color.cyan);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		case 1:
			g.setColor(Color.yellow);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		case 2:
		}
		//�жϷ���
		switch(direction)
		{
		//����
		case 0 :
			g.setColor(Color.cyan);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		case 1 :
			g.setColor(Color.cyan);
			g.fill3DRect(x, y, 5, 30, false );
			g.fill3DRect(x+15,y , 5, 30, false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.drawOval(x+5, y+10, 8, 10);
			g.drawLine(x+10, y+15, x+10, x);
			break;
		
		}
	}
}

//����һ��tank��
class Tank
{
	//Tank�ĺᡢ������
	int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	int y;
	public Tank(int x,int y){
		this.x =x;
		this.y = y;
	}
}

class Hero extends Tank
{

	public Hero(int x, int y) {
		super(x, y);
	
		// TODO Auto-generated constructor stub
	}
	}