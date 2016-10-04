package THREAD;

/**
 * join可以使得线程同步(先后顺序执行)
 * @author Administrator
 *
 */
public class ThreadDemo09 {
	//表示图片是否下载完毕
	public static boolean isFinish=false;
	public static Object obj=new Object();
	public static void main(String[] args) {
		//模拟下载图片
		final Thread download=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("开始下载图片：");
				for(int i=0;i<=100;i++){
					System.out.println("下载已完成"+i+"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("图片下载完成！");
				isFinish=true;
				
				/**
				 * 当图片下载完毕，就应当通知显示图片的线程开始工作。
				 */
				synchronized (obj) {
					/**
					 * notify()方法只会随机解除一个在当前对象上等待的线程
					 * notifyAll()方法解除所有在当前对象上等待的线程
					 * 
					 * 我们调用那个对象的wait()或notify()就应当对当前方法加锁，锁对象就是当前对象
					 */
					obj.notify();
					
				}
			}
		});
		
		/**
		 * 局部匿名内部类(在方法里面定义的类)
		 * main方法中定义了一个内部类show
		 * 该内部类中若想引用main方法中的其他局部变量
		 * 那么这个变量必须是final的
		 */
		//模拟加载图片
		Thread show=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("开始显示图片！");
				//这里应该等待 下载线程将图片下载完毕
				try {
					/*//第一种等待方式
					download.join();*/
					
					//第二种等待方式
					synchronized (obj) {
						obj.wait();
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(isFinish){
					System.out.println("图片显示完成！");
				}else{
					throw new RuntimeException("没有找到图片");
				}
			}
		});
		
		download.start();
		show.start();
	}

}
