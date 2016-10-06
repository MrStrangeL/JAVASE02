package XML;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/** 
 * 使用DOM来解析XML文件
 * @author  作者 E-mail:1832567496@qq.com 
 * @date 创建时间：2016年10月6日 下午5:44:16 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class XMLDemo01 {

	public static void main(String[] args) {
		try {
			/**
			 * 解析XML文件的基本流程：
			 * 1.创建SAXReader,用来读取XML文件
			 * 2.指定XML文件使得SAXReader读取，并解析文档对象Document
			 * 3.获取根元素
			 * 4.获取每一个元素，从而达到解析的目的
			 */
			SAXReader saxReader=new SAXReader();
			
			/**
			 * read()方法的作用:
			 * 读取给定的xml，并将其解析转换为一个Document对象。
			 * 实际上这里已经完成了对整个xml解析的工作，并且将所有的内容封装到了
			 * Document对象中。
			 * Document对象可以描述当前xml文档
			 */
			Document document=saxReader.read(new FileInputStream("Emp.xml"));
			Element root=document.getRootElement();
			
			/**
			 * 获取根元素下的emp标签
			 */
			List<Element> list=root.elements("emp");
			
			/**
			 * 创建一个集合，用于保存xml文件中的每一个用户信息。我们先将用户信息取出，然后
			 * 创建一个Emp实例，将信息设置到该实例的相应属性上，最终将Emp对象存入到集合中
			 */
			List<Emp> empList=new ArrayList<Emp>();
			/**
			 * 遍历每一个emp标签
			 */
			for (Element element : list) {
				Emp emp=new Emp();
				
				/**
				 * 获取标签的属性
				 * Attribute attribute(String name)
				 */
				Attribute id=element.attribute("id");
				//解析emp标签
				Element name=element.element("name");
				Element age=element.element("age");
				Element gender=element.element("gender");
				Element salary=element.element("salary");
				
				emp.setId(Long.valueOf(id.getValue()));
				emp.setName(name.getTextTrim());
				emp.setAge(Integer.valueOf(age.getTextTrim()));
				emp.setGender(gender.getTextTrim());
				emp.setSalary(Integer.valueOf(salary.getTextTrim()));
				empList.add(emp);
				System.out.println(emp.toString());
				/**
				 * 或者
				 * element.elementText("name");
				 */
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

}
