package FILE;

import java.io.File;
import java.io.FileFilter;

/**
 * listFiles方法支持过滤器
 * FileFilter接口
 * 实现该接口需要实现抽象方法：
 * boolean accept（File f）
 * 该方法要求我们定义过滤条件
 * 
 * listFiles方法会将当前目录下满足accept方法的子项返回
 * @author Administrator
 *
 */
public class FileDemo02 {
	public static void main(String[] args){
		File  dir=new File(".");
		MyFilter filter=new MyFilter();
		//首先判断是不是目录
		if(dir.isDirectory())
		{
			//获取该目录下面的所有子项
			File[] directoryList=dir.listFiles();
			for (File file : directoryList) {
				//找到根据过滤器所定义的文件
				if (filter.accept(file)) {
					String fileNameString=file.getName();
					long fileNameLength=file.length();
					System.out.println("已经找到文件："+fileNameString+":"+fileNameLength);
					//删除指定的文件
					if(file.delete())
					{
						System.out.println("已经删除文件："+fileNameString+":"+fileNameLength);
					}
				}else{
					System.out.println("找不到文件！");
				}
			}
		}
	}
}


//定义一个过滤器
class MyFilter implements FileFilter{

	@Override
	public boolean accept(File file) {
		return file.getName().startsWith("1");
	}
	
}