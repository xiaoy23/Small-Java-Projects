/*���͵ı�Ҫ��
 * Ф�곿
 */
package com.hanshunping25;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Dog> a1 = new ArrayList<Dog>();
		//����һֻ��
		Dog dog1 = new Dog();
		//���뼯��
		a1.add(dog1);
		
		//Dog temp = (Dog)a1.get(0);
		Dog temp = a1.get(0);
	}

}

class Cat
{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
	private int age;
}


class Dog
{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}