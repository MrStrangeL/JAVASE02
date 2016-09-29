package FILEIO;

import java.io.File;

public class FileDemo01 {
	/**
	 * �鿴��ǰĿ¼�������������
	 * @param args
	 */
	public static void main(String[] args){
		File  dir=new File(".");
		//�����ж��ǲ���Ŀ¼
		if(dir.isDirectory())
		{
			//��ȡ��Ŀ¼�������������
			File[] directoryList=dir.listFiles();
			for (File file : directoryList) {
				System.out.println(file.getName()+":"+file.length());
			}
		}
	}
}
