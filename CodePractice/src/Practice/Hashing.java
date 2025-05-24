package Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

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
		
		//Find the word that has the highest length 
		//Output: learning
		String str1 = "I am learning streams API in Java";
		System.out.println("The word that has the highest length : " + Arrays.stream(str1.split("\\s+")).max(Comparator.comparing(String :: length)).get());
		
		//Find the word that has the second highest length
		//Output: streams
		System.out.println("The word that has the second highest length : " + Arrays.stream(str1.split("\\s+")).sorted(Comparator.comparing(String :: length).reversed()).skip(1).findFirst().get());
		
		//Find the 2nd highest length in the given sentence
		//Output: 7
		System.out.println("2nd highest length in the given sentence : " + Arrays.stream(str1.split("\\s+")).map(s -> s.length()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
		
		//Find the words with a specified number of vowels, Number of vowels 2
		//Output: streams, API, Java
		Arrays.stream(str1.split("\\s+")).filter(s -> s.replaceAll("[^aeiouAEIOU]", "").length() == 2).forEach(System.out :: println);
		
		//Remove duplicates from the string and return in the same order
		//Output: dabcefg
		String str2 = "dabcadefg";
		str2.chars().mapToObj(c -> (char) c).distinct().forEach(System.out :: print);
		System.out.println("---------------------------------------");
		//OR: Arrays.stream(str2.split("")).distinct().forEach(System.out :: print);
		
		//Divide given integer list into lists of even and odd numbers
		//Output: [[1, 3, 5, 7, 9, 9], [2, 4, 6, 8]]
		int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
		List<Integer> list = Arrays.stream(intArray).boxed().toList();
		
		List<List<Integer>> finalList = list.stream().collect(Collectors.groupingBy(i -> i%2 == 0, Collectors.toList())).entrySet().stream().map(entry -> entry.getValue()).toList();
		System.out.println("List into lists of even and odd numbers : " + finalList);
		
		//Given an array, find the sum of unique elements
		System.out.println("The sum of unique elements : " +Arrays.stream(intArray).distinct().sum());
		
		//Find the first non-repeated character
		//Output : l
		System.out.println(Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst().get());
		
		//Given an array of integers, group the numbers by the range
		//Output : {0=[2, 3], 10=[10, 14], 20=[20, 24], 30=[30, 34], 40=[40, 44], 50=[50, 54, 55]}
		int[] arry = {2, 3, 10, 14, 20, 24, 30, 34, 40 ,44, 50 ,54, 55};
		List<Integer> inputList = Arrays.stream(arry).boxed().toList();
		
		Map<Integer, List<Integer>> mapList = inputList.stream().collect(Collectors.groupingBy(i -> i/10 * 10, LinkedHashMap :: new, Collectors.toList()));
		System.out.println("The numbers by the range : " +mapList);
		
		//Find the products of the first two elements in an int array
		//Output : 6
		System.out.println("products of the first two elements in an int array : " +inputList.stream().limit(2).reduce(1, (a, b) -> a*b));
		
		//Given a list of strings, create a list that contains only integers
		//Output : [123, 456]
		String[] strArray = {"abc", "123", "xyz", "456"};
		System.out.println("The list that contains only integers : " +Arrays.stream(strArray).filter(s -> s.matches("[0-9]+")).map(s -> Integer.parseInt(s)).toList());
		
		//Write a stream program to move all zero’s to beginning of array
		//Output : [0, 0, 0, 0, 2, 3, 10, 14, 4, 5]
		int[] arrys = {2, 3, 10, 14, 0, 0, 0, 4, 0, 5};
		System.out.println("Move all zero’s to beginning of array : " +Arrays.stream(arrys).boxed().collect(Collectors.partitioningBy(i -> i != 0)).values()
				.stream().flatMap(i -> i.stream()).toList());
		
		//INTERVIEW (Deloitte)
		//Write a stream program to move all zero’s to ending of array
		//Output : [2, 3, 10, 14, 4, 5, 0, 0, 0, 0]
		System.out.println("Move all zero’s to ending of array : " +Arrays.stream(arrys).boxed().collect(Collectors.partitioningBy(i -> i == 0)).values()
				.stream().flatMap(i -> i.stream()).toList());
		
		//INTERVIEW (Tech Mahindra)
		int[][] input = {{1,2}, {3,4}, {5,6}};
    	//[1, 2, 3, 4, 5, 6]
    	List<Integer> result = Arrays.stream(input).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    	System.out.println(result);	
	}

}
