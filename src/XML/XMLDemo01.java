package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析XML文件
 * @author 18325
 *
 */
public class XMLDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/**
			 * 解析XML文件的基本流程
			 * 1.创建SAXReader，用来读取XML文件
			 * 2.指定XML文件使得SAXReader读取，并解析文档对象Document
			 * 3.获取根元素
			 * 4.获取每一个元素，从而达到解析的目的
			 */
			//1
			SAXReader reader=new SAXReader();
			//2
			File xmlFile=new File("Emp.xml");
			
			/**
			 * read方法的作用：
			 * 读取给定的XML，并将解析转换为一个Document对象
			 * 实际上这里已经完成了对整个XML解析的工作，并且将所有的内容封装到Document对象中
			 * Document对象可以描述当前XML文档 
			 */
			Document document=reader.read(xmlFile);
			//3 
			Element rootNode=document.getRootElement();
			//4
			/**
			 * Element element(String name)
			 * 获取当前标签下第一个名为给定名字的标签
			 * 
			 * List elements(String name)
			 * 获取当前标签下所有给定名字的标签
			 * 
			 * List elements()
			 * 获取当前标签下的所有子标签
			 */
			//获取到所有的emp子标签
			List<Element> elements=rootNode.elements();
			
			/**
			 * 创建一个集合，用于保存xml中的每一个用户信息。
			 * 我们先将用户信息取出来，然后创建一个Emp实例，将信息设置到该实例的
			 * 向应属性上，最后将所有的emp对象放入到list集合中。
			 * 
			 */
			List<Emp> list=new ArrayList<Emp>();
			//遍历每一个emp标签
			/**
			 * 首先，获取名为"name"的子标签
			 * 其次，获取前后标签中间的文本
			 */
			for(Element emp:elements)
			{
				Emp e=new Emp();
				
				//解析emp标签
				//获取姓名
				Element ename=emp.element("name");
				e.setName(ename.getText());
				
				//一句顶上面的两句代码
				//获取年龄
				String eage=emp.elementText("age");
				e.setAge(Integer.valueOf(eage));
				
				//获取性别
				Element egender=emp.element("gender");
				e.setGender(egender.getText());
				
				//获取工资
				String esalary=emp.elementText("salary");
				e.setSalary(Integer.valueOf(esalary));
				
				//获取标签的属性
				/**
				 * Attribute attribute(String name)
				 * 获取当前标签中指定名字的属性
				 * 
				 * String getValue()
				 * 获取该属性的值
				 * 
				 * String getName()
				 * 获取该属性的名字
				 */
				Attribute attribute=emp.attribute("id");
				e.setId(Long.valueOf(attribute.getValue()));
				
				list.add(e);
			}
			System.out.println("解析了"+list.size()+"个员工的信息");
			
			//输出每一个员工的信息
			for (Emp emp : list) {
				System.out.println(emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
