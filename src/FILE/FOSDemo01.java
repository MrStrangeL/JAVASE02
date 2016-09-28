package FILE;

import java.io.FileOutputStream;

/**
 * InputStream:输入流(输入流是用来读的)---->>读入
 * OutputStream:输出流(输出流是用来写的)---->>写出
 * InputStream和OutputStream是抽象类，收所有字节输入流和字节输出流的父类
 */

/**
 * FileOutputStream:节点流(低级流)，向文件中写出数据 
 * @author Administrator
 *
 */
public class FOSDemo01 {
	public static void main(String[] args){
		String font="输出流是用来写入数据的！";
		FileOutputStream fos;
		try {
			//向文件中写入字节数组
			fos = new FileOutputStream("FOSDemo.txt");
			fos.write(font.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
