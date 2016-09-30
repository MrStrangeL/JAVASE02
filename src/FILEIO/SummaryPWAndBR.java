package FILEIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SummaryPWAndBR {
	public static void main(String[] args) {
		/**
		 * 使用字符缓冲输入流和字符缓冲输出流实现文件的复制
		 * 1.打开文件
		 * 2.设置字符集
		 * 3.进行读写操作
		 * 4.关闭流
		 */
		try {
			long begin=System.currentTimeMillis();
			//打开源文件
			FileInputStream fis=new FileInputStream("pwSrc.txt");
			//设置字符集
			InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
			//从源文件读入数据
			BufferedReader br=new BufferedReader(isr);
			
			
			//打开目标文件
			FileOutputStream fos=new FileOutputStream("pwDest.txt");
			//设置字符集
			OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
			//写入数据到目标文件
			PrintWriter pw=new PrintWriter(osw, true);
			
			int size=0;
			char[] buffer=new char[10240];
			while((size=br.read(buffer, 0, buffer.length))!=-1){
				pw.write(buffer, 0, size);
			}
			br.close();
			pw.close();
			long end=System.currentTimeMillis();
			System.out.println("使用字符缓冲输入流实现文件的复制完毕！耗时："+(end-begin)+"毫秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
