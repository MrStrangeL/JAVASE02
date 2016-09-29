package FILEIO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import tools.Person;

/**
 * ObjectInputStream:高级流，对象输入流
 * ObjectInputStream 对以前使用 ObjectOutputStream 写入的基本数据和对象进行反序列化。 
 * 有支持 java.io.Serializable 或 java.io.Externalizable 接口的对象才能从流读取。 
 * @author Administrator
 *
 */
public class OISDemo01 {
	public static void main(String[] args){
		try {
			FileInputStream fis=new FileInputStream("OOS.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Person person=(Person)ois.readObject();
			System.out.println(person.getName());
			System.out.println(person.getAge());
			System.out.println(person.getSex());
			ArrayList<String> other=person.getOther();
			for (String string : other) {
				System.out.println(string);
			}
			ois.close();
			System.out.println("反序列化成功！");
		} catch (Exception e) {
				e.printStackTrace();
		}
		System.exit(0);
	}
}
