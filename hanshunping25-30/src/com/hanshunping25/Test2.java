package com.hanshunping25;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<String> gen1 = new Gen<String>("aaa");
		gen1.showTypeName();
	}

}


//����һ����
class Gen<T>
{
	private T o;
	
	public Gen(T a) {
		o = a;
	}

	//�õ�T����������
	public void showTypeName()
	{
		System.out.println("Type is " + o.getClass().getName());
	}
}