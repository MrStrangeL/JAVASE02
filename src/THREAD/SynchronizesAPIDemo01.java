package THREAD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 将集合或Map转换为线程安全的
 * @author Administrator
 *
 *Collection是集合的接口
 *Collections的集合的工具类
 *
 */
public class SynchronizesAPIDemo01 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//将list转换为线程安全的(同步的)
		list=Collections.synchronizedList(list);
		System.out.println(list);
		
		Map<String, String> map=new HashMap<String,String>();
		map.put("姓名", "赵亮");
		map.put("学校","华北水利水电大学");
		
		//将map转换为线程安全的
		map=Collections.synchronizedMap(map);
		System.out.println(map.toString());
		
		Set<String> set=new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		
		//将set转换为线程安全的
		set=Collections.synchronizedSet(set);
		System.out.println(set.toString());
	}

}
