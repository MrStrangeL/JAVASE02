package XML;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/** 
 * DOM4J对Xpath的支持
 * @author  作者 E-mail:1832567496@qq.com 
 * @date 创建时间：2016年10月6日 下午9:18:59 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class XMLDemo03 {

	public static void main(String[] args) {
		try {
			SAXReader saxReader=new SAXReader();
			Document myEmp=saxReader.read(new File("MyEmp.xml"));
			String path="/list/emp[salary>5000]";
			List list=myEmp.selectNodes(path);
			for (Object object : list) {
				System.out.println(object.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
