package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 将集合与Map转换为线程安全的 ArrayList，LinkedList，HashSet,HashMap
 * 都不是线程安全的。多线程情况下操作他们都会产生线程安全问题。 我们可以使用Collections这个集合的工具类将上述 的数据结构转换为线程安全的。
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
		 * 该静态方法用于将给定的List集合转换为一个线程 安全的List
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);

		/*
		 * HashSet也不是线程安全的
		 */
		Set<String> set = new HashSet<String>(list);
		/*
		 * 将给定的Set集合转换为线程安全的。
		 */
		set = Collections.synchronizedSet(set);
		System.out.println(set);

		/*
		 * HashMap也不是线程安全的。
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("语文 ", 98);
		map.put(" 数学 ", 94);
		map.put(" 英语 ", 96);
		/*
		 * 将给定的Map转换为线程安全的。
		 */
		map = Collections.synchronizedMap(map);
		System.out.println(map);

		/*
		 * 线程安全的集合和Map都将存取元素的方法 修饰了synchronized，所以多个线程调用 存方法是同步的，取也一样，并且由于这些
		 * 方法都修饰了，所以他们之间还存在互斥效果。 意思是说，当两个线程一个调用存元素的同时，另一个 线程也不能取。
		 * 但是，当我们使用迭代器遍历集合或Map的时候 遍历的过程与集合的过程之间没有互斥性！ 我们知道遍历集合的过程中不能通过集合的方法
		 * 修改元素数量，但是由于遍历与增删之间没有互斥 就可能导致其他线程在这个过程转换增删了元素， 导致遍历出现异常。
		 */
	}
}
