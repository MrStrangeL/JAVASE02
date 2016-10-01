package EXCEPTION;

import java.util.List;

/**
 * Java就近调用原则的前提：没有找到对应的匹配参数
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo05 {
	public static void main(String[] args){
		//null是引用类型，所以在就近调用的时候会排除java中的所有基本类型
		test(null);
	}
	
	public static void test(byte a){
		System.out.println("byte");
	}
	
	public static void test(short a){
		System.out.println("short");
	}
	
	public static void test(int a){
		System.out.println("int");
	}
	
	public static void test(float a){
		System.out.println("float");
	}
	
	public static void test(double a){
		System.out.println("double");
	}
	
/*	public static void test(Object a){
		System.out.println("Object");
	}*/
	
	public static void test(String a){
		System.out.println("String");
	}
	
/*	public static void test(List a){
		System.out.println("List");
	}*/
}
