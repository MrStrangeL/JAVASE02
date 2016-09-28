package tools;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	/**
	 * 序列化的ID
	 */
	private static final long serialVersionUID = 6871740251451383067L;
	private String name;
	private int age;
	private char sex;
	private ArrayList<String> other;
	public Person(){
		
	}
	public Person(String name, int age, char sex, ArrayList<String> other) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.other = other;
	}
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public ArrayList<String> getOther() {
		return other;
	}
	public void setOther(ArrayList<String> other) {
		this.other = other;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
