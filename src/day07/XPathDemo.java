package day07;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��XPath���ټ���XML�ĵ��е���Ϣ
 * 
 * @author 24470
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));

			// /*
			// * �鿴����Ա��������
			// * /list/emp/name
			// */
			// List<Element> nameList
			// = doc.selectNodes(
			// "/list/emp/name"
			// );
			// for(Element nameEle : nameList){
			// System.out.println(
			// nameEle.getText()
			// );
			// }

			/*
			 * �鿴���ʸ���6000��Ա�������� /list/emp[salary>6000]/name
			 */
			List<Element> nameList = doc
					.selectNodes("/list/emp[salary>6000]/name");
			for (Element nameEle : nameList) {
				System.out.println(nameEle.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
