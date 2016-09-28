package FILE;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * BufferedInputStream:处理流(高级流)，缓冲输入流
 * @author Administrator
 *
 */
public class BISDemo01 {
	public static void main(String[] args){
		try {
			FileInputStream fis=new FileInputStream("BISDemo.txt");
			BufferedInputStream bis=new BufferedInputStream(fis);
			String content=null;
			byte[] buffer=new byte[10240];
			int flag=0;
			while((flag=bis.read(buffer))!=-1){
				content+=new String(buffer, 0, flag);
			}
			System.out.println(content);
			//关闭的时候只需要关闭最外层的流就行了
			bis.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
