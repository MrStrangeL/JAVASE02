package FILEIO;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Reader是所有字符输入流的父类，是抽象类
 * InputStreamReader:字符输入流(高级流),用于读入文本数据
 * @author Administrator
 *
 */
public class ISRDemo01 {
	public static void main(String[] args){
		/**
		 * 从文件中读取字符数据
		 * 1.从文件中读取(FileInputStream)
		 * 2.字符数据(InputStreamReader)
		 */
		try {
			FileInputStream fis=new FileInputStream("OSW.txt");
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			int size=0;
			//每次读入一个字符，读"低16位"
			while((size=isr.read())!=-1){
				char content=(char)size;
				System.out.print(content);
			}
			isr.close();
			
			FileInputStream fis1=new FileInputStream("OSW.txt");
			InputStreamReader isr1=new InputStreamReader(fis1, "UTF-8");
			char[] buffer=new char[1024];
			while((size=isr1.read(buffer))!=-1){
				String content=new String(buffer);
				System.out.println(content);
			}
			isr1.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
