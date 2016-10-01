package EXCEPTION;

import tools.Person;
/**
 * throws:在方法声明的时候同时声明该方法可能会出现的异常
 * 好处：
 * 		在调用throws异常的方法时，我们必须处理该异常
 * 
 * @author Administrator
 *
 */
public class ExceptionDemo04 {
	public static void main(String[] args){
		Person person=new Person();
		try {
			person.setAge(1111);
		} catch (Exception e) {
			//跟踪异常事件发生时执行的堆栈信息
			e.printStackTrace();
			System.out.println("年龄输入有误！");
			System.out.println(e.getMessage());
		}
	}
}
