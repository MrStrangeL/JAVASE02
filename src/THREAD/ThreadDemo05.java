package THREAD;
/**
 * 其他线程API
 * @author Administrator
 *
 */
public class ThreadDemo05 {

	public static void main(String[] args) {
		//线程ID一般是由系统指定
		System.out.println("main方法线程的ID为："+Thread.currentThread().getId());
		//线程名称一般由系统指定，格式为：Thread-X(除了main方法)
		System.out.println("main方法线程的名称为："+Thread.currentThread().getName());
		/**
		 * 线程的优先级(1~10,1最低，5默认，10最高)：优先级越高，获取CPU时间片的机会多
		 */
		System.out.println("main方法线程的优先级为："+Thread.currentThread().getPriority());
		//线程是否处于活动状态
		System.out.println("main方法线程是否活着："+Thread.currentThread().isAlive());
		//线程是否为守护线程
		System.out.println("main方法线程是否为后台线程："+Thread.currentThread().isDaemon());
		//线程是否被中断
		System.out.println("main方法线程是否被中断："+Thread.currentThread().isInterrupted());
		//线程的状态
		System.out.println("main方法线程的状态为："+Thread.currentThread().getState());
	}

}
