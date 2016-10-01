package tools;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	/**
	 * 序列化的ID,只要加了该版本号，在反序列化的时候不论你的类的属性是否改变，只要是版本号不变
	 * 那么会经可能的兼容新版本。
	 * 如果版本号改变了，那么反序列化的过程中就会抛出异常。
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
	public void setAge(int age)throws Exception {
		if(age<=0||age>110){
			/**
			 * 通常情况下若方法中throw出一个异常实例，我们则必须处理该异常
			 * 方法一：
			 * 		为throw添加try  catch块
			 * 方法二：
			 * 		在当前方法上声明该类异常的抛出，以便于通知调用者处理该异常
			 * 调用者依然遵循这两条
			 * 
			 * 语法正确但是不符合业务逻辑的时候我们就手动抛出异常
			 */
			//非检查异常
			throw new RuntimeException("不是人类正常的年龄！");
		}
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
