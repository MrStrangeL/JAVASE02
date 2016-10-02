package THREAD;
/**
 * 使用匿名内部类的方式创建线程
 * @author Administrator
 *
 */
public class ThreadDemo03 {

	public static void main(String[] args) {
		//1
		Thread thread1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是谁啊？");
				}
			}
		};
		
		
		//2
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					System.out.println("我是你爸爸。");
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}
