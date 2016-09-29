package FILEIO;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile随机访问文件的读取和写入
 * 在这里我们new两个RandomAccessFile的实例出来，一个用来向文件中存入数据，另一个用来读取文件中的数据，假设demo.dat文件已经存在
 * @author Administrator
 *
 */
public class RandomAccessFileDemo01 {
	public static void main(String[] args)
	{
		try {
			//构造方法一，该实例用来向文件中写入数据
			RandomAccessFile raf=new RandomAccessFile("demo.dat", "rw");
			//构造方法二，该实例用来读取文件中的数据
			File file=new File("demo.dat");
			RandomAccessFile raf1=new RandomAccessFile(file, "rw");
			
			/**
			 * public void write(int b)throws IOException
			 * 每次只写入一个字节，写入整数的"低8位"
			 */
			int x=999999999;//二进制表示为：00111011 10011010 11001001 11111111
			raf.write((x>>>24)&0xff);//写入高8位：00111011
			System.out.println(Integer.toBinaryString((x>>>24)&0xff));
			raf.write(x>>>16&0xff);//写入中上8位：10011010
			System.out.println(Integer.toBinaryString((x>>>16)&0xff));
			raf.write(x>>>8&0xff);//写入中下8位：11001001
			System.out.println(Integer.toBinaryString((x>>>8)&0xff));
			raf.write(x);//写入低8位置：11111111
			System.out.println(Integer.toBinaryString((x>>>0)&0xff));
			raf.close();
			
			
			/**
			 * 从当前文件中读取一个字节，将该字节存入返回的int中
			 * 若返回值为-1，则说明读取到了文件的末尾(EOF:END OF FILE)
			 */
			int a=raf1.read();
			int b=raf1.read();
			int c=raf1.read();
			int d=raf1.read();
			//将每次读取出来的数据依次算术移位
			int readX=(a<<24)+(b<<16)+(c<<8)+(d);
			System.out.println("读取出来的数据为："+readX);
			raf1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
