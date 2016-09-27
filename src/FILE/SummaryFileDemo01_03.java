package FILE;

import java.io.File;
import java.io.IOException;

public class SummaryFileDemo01_03 {

	public static void main(String[] args) {
		createNewFile();
		getFileInfo();
		deleteFile();
	}
	
	public static void createNewFile(){
		File file=new File("..\\test.txt");
		//1.首先判断该文件是否存在
		if(file.exists()){
			System.out.println("该文件已经存在！");
		}else{
			try {
				//2.创建文件
				if(file.createNewFile()){
					System.out.println("文件创建成功！");
				}else{
					System.out.println("文件创建失败！");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteFile()
	{
		File file=new File("..\\test.txt");
		//1.首先判断该文件是否存在
		if(file.exists()){
			//2.删除文件
			if(file.delete())
			{
				System.out.println("文件删除成功！");
			}else{
				System.out.println("文件删除失败！");
			}
		}else{
			System.out.println("文件不存在！");
		}
	}
	
	public static void getFileInfo()
	{
		File file=new File("..\\test.txt");
		//1.首先判断该文件是否存在
		if(file.exists()){
			//2.返回该文件的绝对路径
			System.out.println("该文件的绝对路径为："+file.getAbsolutePath());
			try {
				System.out.println("该文件的规范路径为："+file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("该文件的名称为："+file.getName());
			System.out.println("该文件的父目录为："+file.getParent());
			//3.判断file是文件还是目录
			if(file.isFile())
			{
				System.out.println("file是一个文件！");
			}else if(file.isDirectory()){
				System.out.println("file是目录！");
			}
			else if(file.isHidden()){
				System.out.println("file是一个隐藏文件！");
			}else{
				System.out.println("file既不是目录也不是文件！");
			}
		}else{
			System.out.println("文件不存在！");
		}
	}
	
	public static void createDirectory()
	{
		/**
		 * File.separator:
		 * 与系统有关的默认名称分隔符。
		 * 此字段被初始化为包含系统属性 file.separator 值的第一个字符。
		 * 在 UNIX 系统上，此字段的值为 '/'；
		 * 在 Microsoft Windows 系统上，它为 '\\'。
		 */
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
