package FILE;

import java.io.File;
import java.io.IOException;

/**
 * 创建多级目录下面的一个文件
 * @author Administrator
 *
 */
public class FileDemo03 {
	public static void main(String[] args){
		File file=new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"d.txt");
		//先得到该文件的父目录
		File parent=file.getParentFile();
		//如果父目录不存在，则必须先将父目录创建出来
		if(!parent.exists())
		{
			System.out.println("该文件的父目录不存在，正在创建中！");
			//创建该文件的所有父目录
			if(parent.mkdirs()){
				System.out.println("父目录创建完毕！");
				if(!file.exists()){
					try {
						//创建该文件
						if(file.createNewFile()){
							System.out.println("文件创建完毕！");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
