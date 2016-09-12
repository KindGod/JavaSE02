package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XML�ĵ�
 * 
 * @author 24470
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		try {
			/*
			 * ʹ��DOM����XML�ĵ��Ĵ������� 1:����SAXReader 2:��ȡXML�ĵ����ݲ����н���(��ȡ��
			 * ������)������Document���� Document����ͱ�ʾXML�ĵ���Ϣ�� ��ʱ�������ὫXML��Ϣȫ�������ڴ�
			 * 3:ͨ��Document�����ȡ��Ԫ�� 4:����XML�ĵ��ṹ��ͨ����Ԫ���������� ���մﵽ����XML�ĵ���Ŀ�ġ�
			 */
			// 1
			SAXReader reader = new SAXReader();

			// 2
			Document document = reader.read(new File("emplist.xml"));

			// 3
			/*
			 * Document�ṩ�˻�ȡ��Ԫ�صķ���: Element getRootElement()
			 * 
			 * Element���ڱ�ʾXML�ĵ��е�һ�� Ԫ��(һ�Ա�ǩ)��
			 * 
			 * org.dom4j.Element
			 */
			Element root = document.getRootElement();

			// 4
			/*
			 * ��XML�����õ�ÿһ��emp��ǩ��ʾ��Ա�� ��Ϣ��������������һ��Emp���󱣴棬 ������һ�����ϡ�
			 * ʵ�ʿ����У����ǲ���ÿ��ʹ��Ա����Ϣ��ȥ ��ȡXML�ļ�������ֻ����һ�Σ�Ȼ���ظ�ȥ ʹ������ÿһ��Emp����
			 */
			List<Emp> empList = new ArrayList<Emp>();
			/*
			 * Element�ṩ��һЩ���õĻ�ȡ�ӱ�ǩ�� ����: Element element(String name)
			 * ��ȡ��ǰ��ǩ�¸������ֵ��ӱ�ǩ��
			 * 
			 * List elements() ��ȡ��ǰ��ǩ�����е��ӱ�ǩ
			 * 
			 * List elements(String name) ��ȡ��ǰ��ǩ������ͬ���ӱ�ǩ
			 */
			List<Element> list = root.elements();
			// ������ȡÿһ��emp��ǩ
			for (Element empEle : list) {
				// ��������
				Element nameEle = empEle.element("name");
				/*
				 * String getText() ��ȡ��ǰ��ǩ�м���ı���Ϣ String getTextTrim()
				 * ��ȡ�ı���ͬʱȥ�����ߵĿհ�
				 */
				String name = nameEle.getTextTrim();

				// ����AGE
				int age = Integer.parseInt(empEle.elementTextTrim("age"));// trim:ȥ�հ�

				// ����GENDER
				String gender = empEle.elementText("gender");

				// ����SALARY
				int salary = Integer.parseInt(empEle.elementText("salary"));

				// ����ID
				/*
				 * Element�ṩ�����ڻ�ȡ��ǰ��ǩ���� ��Ϣ�ķ���: Attribute attribute(int index)
				 * ��ȡָ���±��Ӧ�����ԣ�0��ʾ��һ������
				 * 
				 * Attribute attribute(String name) ��ȡ�������ֵ�����
				 * 
				 * Attribute��ÿһ��ʵ������ʾĳ����ǩ �е�һ�����ԣ�ͨ�������Ի�ȡ�����Ե� �����Լ���Ӧ��ֵ��
				 */

				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(attr.getValue());

				Emp emp = new Emp(id, name, age, gender, salary);

				empList.add(emp);
			}

			System.out.println("������" + empList.size() + "��Ա����Ϣ");
			for (Emp e : empList) {
				System.out.println(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
