package FILEIO;

import java.io.File;
import java.io.IOException;

/**
 * �����༶Ŀ¼�����һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo03 {
	public static void main(String[] args){
		File file=new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"d.txt");
		//�ȵõ����ļ��ĸ�Ŀ¼
		File parent=file.getParentFile();
		//�����Ŀ¼�����ڣ�������Ƚ���Ŀ¼��������
		if(!parent.exists())
		{
			System.out.println("���ļ��ĸ�Ŀ¼�����ڣ����ڴ����У�");
			//�������ļ������и�Ŀ¼
			if(parent.mkdirs()){
				System.out.println("��Ŀ¼������ϣ�");
				if(!file.exists()){
					try {
						//�������ļ�
						if(file.createNewFile()){
							System.out.println("�ļ�������ϣ�");
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
