package day07;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * ʹ��DOM����XML�ĵ�
 * 
 * @author 24470
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		try {
			List<Emp> empList = new ArrayList<Emp>();

			empList.add(new Emp(1, "����", 25, "��", 5000));
			empList.add(new Emp(2, "����", 28, "Ů", 8000));
			empList.add(new Emp(3, "����", 45, "��", 15000));
			empList.add(new Emp(4, "����", 35, "Ů", 12000));
			empList.add(new Emp(5, "Ǯ��", 29, "��", 6500));
			/*
			 * ����XML�ĵ��Ĵ��²���: 1:����Document���󣬱�ʾ�ĵ� 2:��Document����Ӹ�Ԫ��
			 * 3:���Ԫ����������ɲ���Ԫ����� �ĵ��ṹ 4:����XMLWriter 5:��Documentд������д���ļ���
			 * ������һ��XML�ļ�����ͨ��Socket ��ȡ�������д�����ǽ�XML���ݷ��� ��Զ�˼���� 6:�ر�XMLWriter
			 */

			// 1
			/*
			 * ͨ��DOcumentHelper�ľ�̬���������� һ��Documentʵ��
			 */
			Document document = DocumentHelper.createDocument();

			// 2
			/*
			 * Document�ṩ����Ӹ�Ԫ�صķ��� Element addElement(String name)
			 * ��ǰ�ĵ���������Ӹ������ֵĸ�Ԫ�أ��� �����Ϻ�Ὣ��Ԫ����Element�������ʽ ���أ���������ͨ��������ӱ�ǩ��
			 * 
			 * �÷������ܱ��������Σ���Ϊһ���ĵ��й涨 ֻ����һ����Ԫ��
			 */
			Element root = document.addElement("list");

			// 3
			for (Emp emp : empList) {
				/*
				 * Elementͬ���ṩ��addElement ������������ǰ��ǩ����Ӹ��� ���֣�������ǰ��ǩ����Ӹ���
				 * ���ֵ��ӱ�ǩ: Element addElement(String name)
				 */
				Element empEle = root.addElement("emp");

				// ��emp��ǩ��׷���ӱ�ǩname
				Element nameEle = empEle.addElement("name");
				// ���ǩ�м�����ı���Ϣ
				nameEle.addText(emp.getName());

				// ���age��ǩ������ֵ
				empEle.addElement("age").addText(emp.getAge() + "");

				// ���gender��ǩ������ֵ
				empEle.addElement("gender").addText(emp.getGender());

				// ���salary��ǩ������ֵ
				empEle.addElement("salary").addText(emp.getSalary() + "");

				// ���id����
				empEle.addAttribute("id", emp.getId() + "");
			}

			// 4
			XMLWriter writer = new XMLWriter();

			// 5
			writer.setOutputStream(new FileOutputStream("myemp.xml"));
			// ���ĵ�����д��
			writer.write(document);

			// 6
			writer.close();
			System.out.println("д����ϣ�");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
