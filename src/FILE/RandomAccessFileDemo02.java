package FILE;

import java.io.RandomAccessFile;

public class RandomAccessFileDemo02 {

	public static void main(String[] args) {
		/**
		 * 案例：两个文件之间的复制
		 * 1.先new一个RandomAcessFile用来读取文件里面的数据
		 * 2.继续new一个RandomAcessFile用户写入读取到的数据
		 * 3.直到读取数据的返回值为-1时则说明读取完毕
		 */
		try {
			//可以使用大概5MB大小的文件来测试
			long begin=System.currentTimeMillis();
			RandomAccessFile  src=new RandomAccessFile("src.txt", "rw");
			RandomAccessFile dest=new RandomAccessFile("dest.txt", "rw");
			
			/**
			 * 按一个字节一个字节的读取
			 * 按一个字节一个字节的写入
			 * 
			 */
			int flag=0;
			while((flag=src.read())!=-1){
				dest.write(flag);
			}
			if(flag==-1)
			{
				System.out.println("文件复制成功！");
			}else{
				System.out.println("文件复制失败！");
			}
			src.close();
			dest.close();
			long end=System.currentTimeMillis();
			System.out.println("按字节读写的时间为："+(end-begin));
			/**
			 * 使用字节数组来读取和写入
			 */
			
			long begin1=System.currentTimeMillis();
			RandomAccessFile  src1=new RandomAccessFile("src1.txt", "rw");
			RandomAccessFile dest1=new RandomAccessFile("dest1.txt", "rw");
			//建立一个文件缓冲区，每次读取buffer.length大小的数据
			byte[] buffer=new byte[1024*8];
			int flag1=0;
			//每一次循环读写的数据量为1024*8个字节的数组，返回值为实际读到的字节数
			while((flag1=src1.read(buffer))!=-1){
				dest1.write(buffer);
			}
			if(flag1==-1)
			{
				System.out.println("文件复制成功！");
			}else{
				System.out.println("文件复制失败！");
			}
			src1.close();
			dest1.close();
			long end1=System.currentTimeMillis();
			System.out.println("按字节数组读写的时间为："+(end1-begin1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
