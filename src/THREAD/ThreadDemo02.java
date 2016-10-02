package THREAD;
/**
 * 第二种创建线程的方式
 * 定义线程体Runnable,实现Runnable接口
 * 优点：
 * 我们可以去继续继承其他类
 * @author Administrator
 *
 */
public class ThreadDemo02 {

	public static void main(String[] args) {
		Runnable runnable1=new MyRunnable1();
		Runnable runnable2=new MyRunnable2();
		
		Thread thread1=new Thread(runnable1);
		Thread thread2=new Thread(runnable2);
		thread1.start();
		thread2.start();
	}

}

class  MyRunnable1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
	
}

class  MyRunnable2 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			System.out.println("我是修水管的。");
		}
	}
	
}