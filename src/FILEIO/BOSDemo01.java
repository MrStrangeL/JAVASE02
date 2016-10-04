package FILEIO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * BufferedOutputStream:处理流(高级流)，缓冲输出流
 * @author Administrator
 *
 */
public class BOSDemo01 {
	public static void main(String[] args){
		try {
			FileOutputStream fos=new FileOutputStream("BOSDemo.txt");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			String content="我是缓冲输出流测试数据！";
			bos.write(content.getBytes(),0,content.getBytes().length);
			bos.flush();
			bos.close();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
