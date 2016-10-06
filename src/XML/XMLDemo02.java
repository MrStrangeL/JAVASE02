package XML;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM写一个XML
 * 
 * @author 作者 E-mail:1832567496@qq.com
 * @date 创建时间：2016年10月6日 下午7:41:38
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class XMLDemo02 {

	public static void main(String[] args) {
		try {
			List<Emp> empList = new ArrayList<Emp>();
			empList.add(new Emp(201319201, "Jack", 23, "男", 3000));
			empList.add(new Emp(201319202, "Tom", 20, "男", 4000));
			empList.add(new Emp(201319203, "Alice", 18, "女", 6000));
			empList.add(new Emp(201319204, "Tony", 22, "男", 5000));
			empList.add(new Emp(201319205, "Salina", 24, "女", 8000));

			/**
			 * 生成一个xml的基本步骤： 1.创建文档对象Document 2.为Document添加根节点 3.为根节点组建树状结构
			 * 4.创建XMLWriter 5.为XMLWriter指定写出目标 6.写出XML文件
			 */
			Document xmlDocument = DocumentHelper.createDocument();
			/**
			 * Document里面的addElement()方法: 该方法用于向文档中添加给定名字的根元素，返回的Element实例就是该根元素
			 * 需要注意的是，该方法只能调用一次，调用第二次会抛出异常。
			 */
			Element rootElement = xmlDocument.addElement("list");
			for (Emp emp : empList) {
				/**
				 * Element同样支持addElement()方法 向当前标签中添加给定名字的子标签
				 */
				Element empElement = rootElement.addElement("emp");
				empElement = empElement.addAttribute("id", String.valueOf(emp.getId()));

				Element nameElement = empElement.addElement("name");
				nameElement.setText(emp.getName());

				Element ageElement = empElement.addElement("age");
				ageElement.setText(String.valueOf(emp.getAge()));

				Element genderElement = empElement.addElement("gender");
				genderElement.setText(emp.getGender());

				Element salaryElement = empElement.addElement("salary");
				salaryElement.setText(String.valueOf(emp.getSalary()));

			}
			XMLWriter xmlWriter = new XMLWriter();
			xmlWriter.setOutputStream(new FileOutputStream("MyEmp.xml"));

			/**
			 * 将Document对象写入到文件中
			 */
			xmlWriter.write(xmlDocument);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
