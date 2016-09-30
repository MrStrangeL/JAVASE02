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
			FileInputStream fis=new FileInputStream("pw.txt");
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			/**
			 * public String readLine()
			 * 该方法的返回值如果为null，则说明数据已经没有了
			 */
			int size=0;
			while((size=br.read())!=-1){
				char content=(char)size;
				System.out.println(content);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
