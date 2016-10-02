package THREAD;
/**
 * 第一种创建线程的方式：
 * 	继承Thread类，重写run方法
 * 
 * 缺点：
 * 	在Java中只能单继承，如果我们同时需要继承其他类，那么就继承不了，我们一般很少用这种方式
 * 
 * @author Administrator
 *
 */
public class ThreadDemo01{

	public static void main(String[] args){
		/*//有先后顺序的运行方式是同步的
		for(int i=0;i<10;i++){
			System.out.println("你是谁啊？");
		}
		
		for(int i=0;i<10;i++){
			System.out.println("我是查水表的。");
		}*/
		
		//各不相干，各干各的，在多个线程里面执行就是异步操作
		
		MyThread1 thread1=new MyThread1();
		MyThread2 thread2=new MyThread2();
		/**
		 * start方法用于将线程纳入线程调度，线程进入runnable状态，等待线程调度分配时间。
		 * 当线程调度将时间片分配给当前线程，该线程的run方法才开始被执行。
		 * 直到线程的run方法执行完毕，线程结束最终被回收。
		 * 在线程的run方法执行期间，该线程处于走走停停。
		 */
		thread1.start();
		thread2.start();
	}

}


class MyThread1 extends Thread {

	@Override
	public void run() {
		super.run();
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
	
}

class MyThread2 extends Thread{

	@Override
	public void run() {
		super.run();
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的？");
		}
	}
	
}