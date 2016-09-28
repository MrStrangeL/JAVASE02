package FILE;

import java.io.FileInputStream;

/**
 * FileInputStream:节点流(低级流)，从文件中读入数据
 * @author Administrator
 *
 */
public class FISDemo01 {
	public static void main(String[] args){
		String content=null;
		try {
			int size=0;
			//定义一个字节缓冲区
			byte[] buffer=new byte[1024];
			FileInputStream fis=new FileInputStream("FOSDemo.txt");
			while((size=fis.read(buffer))!=-1){
				content=new String(buffer, 0, size);
			}
		System.out.println(content);
		fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
