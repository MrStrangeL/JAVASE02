package FILEIO;

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
		//1.�����жϸ��ļ��Ƿ����
		if(file.exists()){
			System.out.println("���ļ��Ѿ����ڣ�");
		}else{
			try {
				//2.�����ļ�
				if(file.createNewFile()){
					System.out.println("�ļ������ɹ���");
				}else{
					System.out.println("�ļ�����ʧ�ܣ�");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteFile()
	{
		File file=new File("..\\test.txt");
		//1.�����жϸ��ļ��Ƿ����
		if(file.exists()){
			//2.ɾ���ļ�
			if(file.delete())
			{
				System.out.println("�ļ�ɾ���ɹ���");
			}else{
				System.out.println("�ļ�ɾ��ʧ�ܣ�");
			}
		}else{
			System.out.println("�ļ������ڣ�");
		}
	}
	
	public static void getFileInfo()
	{
		File file=new File("..\\test.txt");
		//1.�����жϸ��ļ��Ƿ����
		if(file.exists()){
			//2.���ظ��ļ��ľ���·��
			System.out.println("���ļ��ľ���·��Ϊ��"+file.getAbsolutePath());
			try {
				System.out.println("���ļ��Ĺ淶·��Ϊ��"+file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("���ļ�������Ϊ��"+file.getName());
			System.out.println("���ļ��ĸ�Ŀ¼Ϊ��"+file.getParent());
			//3.�ж�file���ļ�����Ŀ¼
			if(file.isFile())
			{
				System.out.println("file��һ���ļ���");
			}else if(file.isDirectory()){
				System.out.println("file��Ŀ¼��");
			}
			else if(file.isHidden()){
				System.out.println("file��һ�������ļ���");
			}else{
				System.out.println("file�Ȳ���Ŀ¼Ҳ�����ļ���");
			}
		}else{
			System.out.println("�ļ������ڣ�");
		}
	}
	
	public static void createDirectory()
	{
		/**
		 * File.separator:
		 * ��ϵͳ�йص�Ĭ�����Ʒָ�����
		 * ���ֶα���ʼ��Ϊ����ϵͳ���� file.separator ֵ�ĵ�һ���ַ���
		 * �� UNIX ϵͳ�ϣ����ֶε�ֵΪ '/'��
		 * �� Microsoft Windows ϵͳ�ϣ���Ϊ '\\'��
		 */
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
