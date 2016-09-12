package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ��������Mapת��Ϊ�̰߳�ȫ�� ArrayList��LinkedList��HashSet,HashMap
 * �������̰߳�ȫ�ġ����߳�����²������Ƕ�������̰߳�ȫ���⡣ ���ǿ���ʹ��Collections������ϵĹ����ཫ���� �����ݽṹת��Ϊ�̰߳�ȫ�ġ�
 * 
 * @author 24470
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		/*
		 * �þ�̬�������ڽ�������List����ת��Ϊһ���߳� ��ȫ��List
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);

		/*
		 * HashSetҲ�����̰߳�ȫ��
		 */
		Set<String> set = new HashSet<String>(list);
		/*
		 * ��������Set����ת��Ϊ�̰߳�ȫ�ġ�
		 */
		set = Collections.synchronizedSet(set);
		System.out.println(set);

		/*
		 * HashMapҲ�����̰߳�ȫ�ġ�
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("���� ", 98);
		map.put(" ��ѧ ", 94);
		map.put(" Ӣ�� ", 96);
		/*
		 * ��������Mapת��Ϊ�̰߳�ȫ�ġ�
		 */
		map = Collections.synchronizedMap(map);
		System.out.println(map);

		/*
		 * �̰߳�ȫ�ļ��Ϻ�Map������ȡԪ�صķ��� ������synchronized�����Զ���̵߳��� �淽����ͬ���ģ�ȡҲһ��������������Щ
		 * �����������ˣ���������֮�仹���ڻ���Ч���� ��˼��˵���������߳�һ�����ô�Ԫ�ص�ͬʱ����һ�� �߳�Ҳ����ȡ��
		 * ���ǣ�������ʹ�õ������������ϻ�Map��ʱ�� �����Ĺ����뼯�ϵĹ���֮��û�л����ԣ� ����֪���������ϵĹ����в���ͨ�����ϵķ���
		 * �޸�Ԫ���������������ڱ�������ɾ֮��û�л��� �Ϳ��ܵ��������߳����������ת����ɾ��Ԫ�أ� ���±��������쳣��
		 */
	}
}
