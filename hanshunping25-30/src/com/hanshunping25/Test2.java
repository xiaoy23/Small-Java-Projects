package com.hanshunping25;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String> gen1 = new Gen<String>("aaa");
		gen1.showTypeName();
	}

}


//定义一个类
class Gen<T>
{
	private T o;
	
	public Gen(T a) {
		o = a;
	}

	//得到T的类型名称
	public void showTypeName()
	{
		System.out.println("Type is " + o.getClass().getName());
	}
}