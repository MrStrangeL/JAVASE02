package FILEIO;

import java.io.RandomAccessFile;

/**
 * 查看RandomAcessFile的指针位置
 * RAF总是根据当前指针所指向的位置进行读写操作，并且每次读写后，指针自动向后移动
 * @author Administrator
 *
 */
public class RandomAccessFileDemo03 {
	public static void main(String[] args){
		try {
			RandomAccessFile raf=new RandomAccessFile("demo.t", "rw");
			System.out.println(raf.getFilePointer());//0
			raf.write(97);
			System.out.println(raf.getFilePointer());//1
			
			raf.writeInt(990);
			System.out.println(raf.getFilePointer());//5
			
			/**
			 * 此时指针是向5，所以返回的值为-1(在文件的末尾)
			 */
			int x=raf.read();
			System.out.println(x+","+raf.getFilePointer());
			
			//将文件的指针移动到文件的开头
			raf.seek(0);
			System.out.println(raf.read()+","+raf.getFilePointer());
			System.out.println(raf.readInt()+","+raf.getFilePointer());
			
			
			/**
			 * int skipBytes(int n)
			 * 该方法会尝试跳过n个字节，返回值为实际跳过的字节数，只能往后跳
			 */
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
