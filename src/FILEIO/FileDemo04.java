package FILEIO;

import java.io.File;

public class FileDemo04 {

	/**
	 * 使用递归来删除文件或目录
	 * @param file
	 */
	public static void deleteFile(File file){
		if(file.isDirectory()){
			//如果是目录还要看是否还有子项
			File[] direcctoryArray=file.listFiles();
			//先删除所有子项
			for (File newdirecctory : direcctoryArray) {
				deleteFile(newdirecctory);
			}
		}
		file.delete();
	}
	
	/**
	 * 使用递归来累加数据
	 * @param n
	 * @return
	 */
	public static int add(int n){
		if(n==1){
			return 1;
		}else{
			return n+add(n-1);
		}
	}
}
