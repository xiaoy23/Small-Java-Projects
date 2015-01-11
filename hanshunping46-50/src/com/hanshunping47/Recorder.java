package com.hanshunping47;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;


//Recorder can also save the setting of the game
public class Recorder {
//record the number of enemies in every stage 
private static int enNum = 20;
//set how many lives that user has
private static int myLife = 3;
//recorder enemy killed totally
private static int allEnNum = 0;

private static FileWriter fw =null;
private static BufferedWriter bw = null;
private static FileReader fr = null;
private static BufferedReader br = null;
private  Vector<EnemyTank> ets = new Vector<EnemyTank>();
//to retrieve data from saved files
static Vector<Node> nodes = new Vector<Node>();

public Vector<Node> getNodesAndEnNums()
{
	try{
		fr = new FileReader("d:\\myRecording.txt");
		br = new BufferedReader(fr);
		String n = "";
		//read first line
		n = br.readLine();
		allEnNum = Integer.parseInt(n);
		while((n=br.readLine())!=null)
		{
			String []xyz = n.split(" ");
			for(int i = 0;i< xyz.length;i++)
			{
				Node node = new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
				nodes.add(node);
			}
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			//Later opened , first close
			br.close();
			fr.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	return nodes;
}



//save the total numbers destroyed and the coordination of enemy tanks
public  void keepRecordEnemyTank()
{
		try{
			//create
			fw = new FileWriter("d:\\myRecording.txt");
			bw = new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
			
			//Save the coordinations of the live enemy tanks
			for(int i =0;i<ets.size();i++)
			{
				EnemyTank et = ets.get(i);
				if(et.isLive)
				{
					//is live then save
					String record = et.x+" "+et.y+" "+et.direct;
					
					//write in file
					bw.write(record+"\r\n");
					
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				bw.close();
				fw.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}


//read from recorded file
public static void getRecording()
{
	try{
		fr = new FileReader("d:\\myRecording.txt");
		br = new BufferedReader(fr);
		String n = br.readLine();
		allEnNum = Integer.parseInt(n);
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			//Later opened , first close
			br.close();
			fr.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

//record the number of killed enemies
public static void keepRecording()
{
	try{
		//create
		fw = new FileWriter("d:\\myRecording.txt");
		bw = new BufferedWriter(fw);
		
		bw.write(allEnNum+"\r\n");
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		try{
			bw.close();
			fw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


public static int getEnNum() {
	return enNum;
}
public static void setEnNum(int enNum) {
	Recorder.enNum = enNum;
}
public static int getMyLife() {
	return myLife;
}
public static void setMyLife(int myLife) {
	Recorder.myLife = myLife;
}

//Reduce the number of enemy 
public static void reduceEnNum()
{
	enNum--;
}

//kill an enemy
public static void addEnNumRec()
{
	allEnNum++;
}
public static int getAllEnNum() {
	return allEnNum;
}
public static void setAllEnNum(int allEnNum) {
	Recorder.allEnNum = allEnNum;
}
public  Vector<EnemyTank> getEts() {
	return ets;
}


public  void setEts(Vector<EnemyTank> ets1) {
	this.ets = ets1;
	System.out.println("OK");
}
}
