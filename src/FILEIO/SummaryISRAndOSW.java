package FILEIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SummaryISRAndOSW {

	public static void main(String[] args) {
		/**
		 * 实现文本文件的复制
		 * 1.从文件中读入字符数据
		 * 2.输出到另外一个文件中
		 */
		try {
			long begin=System.currentTimeMillis();
			FileInputStream fis=new FileInputStream("ISR.txt");
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			
			FileOutputStream fos=new FileOutputStream("OSW.txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			
			char[] buffer=new char[10240];
			int size=0;
			while((size=isr.read(buffer))!=-1){
				osw.write(buffer, 0, size);
				osw.flush();
			}
			isr.close();
			osw.close();
			long end=System.currentTimeMillis();
			System.out.println("使用文件输入流和文件输出流实现文件的复制完毕！耗时："+(end-begin)+"毫秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
