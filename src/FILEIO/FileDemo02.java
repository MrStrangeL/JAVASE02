package FILEIO;

import java.io.File;
import java.io.FileFilter;

/**
 * listFiles����֧�ֹ�����
 * FileFilter�ӿ�
 * ʵ�ָýӿ���Ҫʵ�ֳ��󷽷���
 * boolean accept��File f��
 * �÷���Ҫ�����Ƕ����������
 * 
 * listFiles�����Ὣ��ǰĿ¼������accept�����������
 * @author Administrator
 *
 */
public class FileDemo02 {
	public static void main(String[] args){
		File  dir=new File(".");
		MyFilter filter=new MyFilter();
		//�����ж��ǲ���Ŀ¼
		if(dir.isDirectory())
		{
			//��ȡ��Ŀ¼�������������
			File[] directoryList=dir.listFiles();
			for (File file : directoryList) {
				//�ҵ����ݹ�������������ļ�
				if (filter.accept(file)) {
					String fileNameString=file.getName();
					long fileNameLength=file.length();
					System.out.println("�Ѿ��ҵ��ļ���"+fileNameString+":"+fileNameLength);
					//ɾ��ָ�����ļ�
					if(file.delete())
					{
						System.out.println("�Ѿ�ɾ���ļ���"+fileNameString+":"+fileNameLength);
					}
				}else{
					System.out.println("�Ҳ����ļ���");
				}
			}
		}
	}
}


//����һ��������
class MyFilter implements FileFilter{

	@Override
	public boolean accept(File file) {
		return file.getName().startsWith("1");
	}
	
}