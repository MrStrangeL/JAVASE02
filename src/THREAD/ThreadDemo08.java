package THREAD;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep()睡眠
 * @author Administrator
 *
 */
public class ThreadDemo08 {

	public static void main(String[] args) {
		/**
		 * 实现电子表
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		while(true){
			Date date=new Date();
			System.out.println(sdf.format(date));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
