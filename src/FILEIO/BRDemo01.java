package FILEIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * BufferedReader:缓冲字符输入流，高级流
 * 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
 * 可以以行为单位读取字符串
 * @author Administrator
 *
 */
public class BRDemo01 {
	public static void main(String[] args) {
		try {
			/**
			 * 逐个字符的读取
			 */
			FileInputStream fis=new FileInputStream("pw.txt");
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			int size=0;
			while((size=br.read())!=-1){
				char content=(char)size;
				System.out.println(content);
			}
			
			/**
			 * 整行读取
			 */
			FileInputStream fis1=new FileInputStream("pw.txt");
			InputStreamReader isr1=new InputStreamReader(fis1, "UTF-8");
			BufferedReader br1=new BufferedReader(isr1);
			String isNull=null;
			/**
			 * public String readLine()
			 * 该方法的返回值如果为null，则说明数据已经没有了
			 */
			while((isNull=br1.readLine())!=null){
				System.out.println(isNull);
			}
			br.close();
			br1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
