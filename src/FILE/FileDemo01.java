package FILE;

import java.io.File;

public class FileDemo01 {
	/**
	 * 查看当前目录下面的所有子项
	 * @param args
	 */
	public static void main(String[] args){
		File  dir=new File(".");
		//首先判断是不是目录
		if(dir.isDirectory())
		{
			//获取该目录下面的所有子项
			File[] directoryList=dir.listFiles();
			for (File file : directoryList) {
				System.out.println(file.getName()+":"+file.length());
			}
		}
	}
}
