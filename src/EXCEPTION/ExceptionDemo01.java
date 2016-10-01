package EXCEPTION;
/**
 * Java中的异常处理机制   try  catch
 * @author Administrator
 *
 */
public class ExceptionDemo01 {
	public static void main(String[] args){
		//该程序会报错:java.lang.NullPointerException(空指针异常)
		System.out.println("程序开始了!");
		try{
			String string=null;
			/**
			 * 当出现空指针后，jvm创建了一个空指针一场的实例，将异常抛出来
			 */
			System.out.println(string.length());
		}catch(NullPointerException e){
			//处理异常的代码
			System.out.println("出现了空指针异常!");
		}
		System.out.println("程序结束了!");
	}
}
