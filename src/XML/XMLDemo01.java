package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XML�ļ�
 * @author 18325
 *
 */
public class XMLDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/**
			 * ����XML�ļ��Ļ�������
			 * 1.����SAXReader��������ȡXML�ļ�
			 * 2.ָ��XML�ļ�ʹ��SAXReader��ȡ���������ĵ�����Document
			 * 3.��ȡ��Ԫ��
			 * 4.��ȡÿһ��Ԫ�أ��Ӷ��ﵽ������Ŀ��
			 */
			//1
			SAXReader reader=new SAXReader();
			//2
			File xmlFile=new File("Emp.xml");
			
			/**
			 * read���������ã�
			 * ��ȡ������XML����������ת��Ϊһ��Document����
			 * ʵ���������Ѿ�����˶�����XML�����Ĺ��������ҽ����е����ݷ�װ��Document������
			 * Document�������������ǰXML�ĵ� 
			 */
			Document document=reader.read(xmlFile);
			//3 
			Element rootNode=document.getRootElement();
			//4
			/**
			 * Element element(String name)
			 * ��ȡ��ǰ��ǩ�µ�һ����Ϊ�������ֵı�ǩ
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰ��ǩ�����и������ֵı�ǩ
			 * 
			 * List elements()
			 * ��ȡ��ǰ��ǩ�µ������ӱ�ǩ
			 */
			//��ȡ�����е�emp�ӱ�ǩ
			List<Element> elements=rootNode.elements();
			
			/**
			 * ����һ�����ϣ����ڱ���xml�е�ÿһ���û���Ϣ��
			 * �����Ƚ��û���Ϣȡ������Ȼ�󴴽�һ��Empʵ��������Ϣ���õ���ʵ����
			 * ��Ӧ�����ϣ�������е�emp������뵽list�����С�
			 * 
			 */
			List<Emp> list=new ArrayList<Emp>();
			//����ÿһ��emp��ǩ
			/**
			 * ���ȣ���ȡ��Ϊ"name"���ӱ�ǩ
			 * ��Σ���ȡǰ���ǩ�м���ı�
			 */
			for(Element emp:elements)
			{
				Emp e=new Emp();
				
				//����emp��ǩ
				//��ȡ����
				Element ename=emp.element("name");
				e.setName(ename.getText());
				
				//һ�䶥������������
				//��ȡ����
				String eage=emp.elementText("age");
				e.setAge(Integer.valueOf(eage));
				
				//��ȡ�Ա�
				Element egender=emp.element("gender");
				e.setGender(egender.getText());
				
				//��ȡ����
				String esalary=emp.elementText("salary");
				e.setSalary(Integer.valueOf(esalary));
				
				//��ȡ��ǩ������
				/**
				 * Attribute attribute(String name)
				 * ��ȡ��ǰ��ǩ��ָ�����ֵ�����
				 * 
				 * String getValue()
				 * ��ȡ�����Ե�ֵ
				 * 
				 * String getName()
				 * ��ȡ�����Ե�����
				 */
				Attribute attribute=emp.attribute("id");
				e.setId(Long.valueOf(attribute.getValue()));
				
				list.add(e);
			}
			System.out.println("������"+list.size()+"��Ա������Ϣ");
			
			//���ÿһ��Ա������Ϣ
			for (Emp emp : list) {
				System.out.println(emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
