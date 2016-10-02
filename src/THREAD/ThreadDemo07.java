package THREAD;
/**
 * 守护线程(后台线程)的特点：
 * 当进程中只剩下守护线程时，所有守护线程强制终止。GC就是运行在一个守护线程上的。
 * 
 * 当一个程序的所有前台线程执行完毕，那么所有的后台线程都会被强制kill
 * @author Administrator
 *
 */
public class ThreadDemo07 {

	public static void main(String[] args) {
		//前台线程
		Thread front=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:AAAA~~~~~~~~~~");
				System.out.println("音效：噗通。。。");
			}
		});
		
		//后台线程
		Thread back=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("jack:you jump,I jump!");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		front.start();
		
		back.setDaemon(true);
		back.start();
		System.out.println("mian方法执行完毕！");
	}

}
