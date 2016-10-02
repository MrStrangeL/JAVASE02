package THREAD;
/**
 * 测试线程的优先级
 * 理论上线程 的优先级越高，那么被CPU分配时间片的机会也就越多，执行的次数也就越多
 * @author Administrator
 *
 */
public class ThreadDemo06 {

	public static void main(String[] args) {
		Thread normalThread=new Thread(){
			public void run(){
				for(int i=0;i<5000;i++){
					System.out.println("noamal");
				}
			}
		};
		
		Thread minThread=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5000;i++){
					System.out.println("min");
				}
			}
		});
		
		Thread maxThread=new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5000;i++){
					System.out.println("max");
				}
			}
		});
		
		minThread.setPriority(1);
		maxThread.setPriority(10);
		
		minThread.start();
		normalThread.start();
		maxThread.start();
	}

}
