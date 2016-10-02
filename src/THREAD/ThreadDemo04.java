package THREAD;
/**
 * 获取执行当前代码片段的线程
 * @author Administrator
 *
 */
public class ThreadDemo04 {

	public static void main(String[] args) {
		System.out.println("调用main方法的线程 是："+Thread.currentThread());
		test();
		
		Thread thread=new Thread(){
			public void run(){
				System.out.println("匿名内部类的线程为"+Thread.currentThread());
				test();
			}
		};
		thread.start();
	}

	public static void test(){
		System.out.println("调用test方法的线程是："+Thread.currentThread());
	}
}
