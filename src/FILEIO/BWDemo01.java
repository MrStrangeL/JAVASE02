package FILEIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/** 
 * BufferedWriter:字符缓冲输出流(高级流)
 * @author  作者 E-mail:1832567496@qq.com 
 * @date 创建时间：2016年10月9日 上午11:10:21 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class BWDemo01 {

	public static void main(String[] args) {
		try {
			//打开文件
			FileOutputStream fos=new FileOutputStream("pw.txt");
			//设置编码集
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			//将字符输出流包装为字符缓冲输出流
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write("BW测试文字");
			bw.append("BWBWBWBWBW");
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
