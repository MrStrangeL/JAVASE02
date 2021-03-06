package FILEIO;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Writer是所有字符输出流的父类，是抽象类
 * OutputStreamWriter：字符输出流(高级流)，用于写出字符数据
 * @author Administrator
 *
 */
public class OSWDemo01 {
	public static void main(String[] args){
		/**
		 * 向文件中写入字符数据
		 * 1.向文件中写入(FileOutputStream)
		 * 2.字符数据(OutputStreamWriter)
		 * OutputStreamWriter的最主要 的特点就是可以将指定的字符串
		 * 按照特定的字符集转换为字节后写出
		 */
		try {
			//定义一个文件输出流
			FileOutputStream fos=new FileOutputStream("OSW.txt");
			//将文件输出流包装为字符输出流
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			osw.write("You are my wife!");
			osw.append("I love you.");
			osw.flush();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
