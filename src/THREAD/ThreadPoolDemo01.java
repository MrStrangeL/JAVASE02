package THREAD;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 由于重用线程以及控制线程 的数量
 * @author Administrator
 *
 */
public class ThreadPoolDemo01 {

	public static void main(String[] args) {
		//创建一个固定大小的线程池
		ExecutorService threadPool=Executors.newFixedThreadPool(3);
		
		for(int i=0;i<5;i++){
		//任务
		Runnable mission1=new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//分配任务
		threadPool.execute(mission1);
		}
		//关闭线程池
		threadPool.shutdown();
	}

}
