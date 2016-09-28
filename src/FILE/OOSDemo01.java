package FILE;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import tools.Person;

/**
 * ObjectOutputStream:高级流，对象输出流，只能将支持 java.io.Serializable 接口的对象写入流中
 * 
 * 将一个特定的数据结构转换为一组字节的过程称之为序列化
 * 将一组字节转换为特定的数据结构的过程称之为反序列化
 * 将数据写入硬盘长久保存的过程称之为持久化
 * 
 * @author Administrator
 *
 */
public class OOSDemo01 {
	public static void main(String[] args){
		try {
			ArrayList<String> other=new ArrayList<String>();
			other.add("华北水利水电大学");
			other.add("软件学院");
			other.add("软件工程(娱乐软件设计)");
			Person person=new Person("赵亮", 22, '男', other);
			FileOutputStream fos=new FileOutputStream("OOS.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			//将一个对象经行序列化时需要实现Serializable接口
			oos.writeObject(person);
			oos.flush();
			oos.close();
			System.out.println("对象写入成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
