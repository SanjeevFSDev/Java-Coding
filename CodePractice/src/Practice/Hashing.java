package Practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Hashing {

	public static void main(String[] args) {
		
//		Map<String, Integer> hashMap = new HashMap<>();
//		hashMap.put("Sanjeev", 1);
//		hashMap.put("Priti", 0);
//		hashMap.put("Yug", 3);
//		hashMap.put("ABC", 2);
//		
//		Map<String, Integer> synchronizedHashMap = Collections.synchronizedMap(hashMap);
//		
//		//Exception in thread "main" java.util.ConcurrentModificationException
//		for(Map.Entry<String, Integer> entryMap : synchronizedHashMap.entrySet()) {
//			hashMap.put("XYZ", 6);
//			System.out.println(entryMap.getKey()+ " : " +entryMap.getValue());
//		}
		
		
		Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("Sanjeev", 1);
		concurrentHashMap.put("Priti", 4);
		concurrentHashMap.put("Yug", 3);
		concurrentHashMap.put("ABC", 2);
		
		for(Map.Entry<String, Integer> entryMap : concurrentHashMap.entrySet()) {
			concurrentHashMap.put("XYZ", 5);
			System.out.println(entryMap.getKey()+ " : " +entryMap.getValue());
		}

	}

}
