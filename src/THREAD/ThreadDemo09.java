package THREAD;

/**
 * join可以使得线程同步(先后顺序执行)
 * @author Administrator
 *
 */
public class ThreadDemo09 {
	//表示图片是否下载完毕
	public static boolean isFinish=false;
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
					download.join();
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
